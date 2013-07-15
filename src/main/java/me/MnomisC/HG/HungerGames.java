package main.java.me.MnomisC.HG;

import java.util.logging.Logger;

import main.java.me.MnomisC.HG.File.Data;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Minecraft");
	public static HungerGames plugin;
	public Help help;
	public Game game;
	private Data data;
	private Lobby lobby;
	public String sendMessage = ChatColor.AQUA + "[" + ChatColor.GOLD + "HungerGames"
	        + ChatColor.AQUA + "] " + ChatColor.WHITE;

	@Override
	public void onDisable() {
		
		data.save();
		
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + "has been disabled");
	}

	@Override
	public void onEnable() {
		
		data = new Data();
		
		data.initializeFiles();
		
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + pdfFile.getName() + "has been ebabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (commandLabel.equalsIgnoreCase("hungergames") || commandLabel.equalsIgnoreCase("hg")) {
			if (args.length != 0) {
				if (args[0].equalsIgnoreCase("help")) {
					help.help(sender);
				} else if (args[0].equalsIgnoreCase("join")) {
					try {
						if (game.joinGame(sender)) {

							sendMessage(ChatColor.GREEN + "Succeesfully joined the game!", sender);
						} else
							sendMessage(ChatColor.RED + "You are already in a game", sender);
					} catch (Exception e) {
						sendMessage(ChatColor.RED + "Something went wrong! Try again!", sender);
						e.printStackTrace();
					}
				} else if (args[0].equalsIgnoreCase("leave")) {
					if (game.leaveGame(sender)) {
						
						sendMessage(ChatColor.GREEN + "Succesfully leaved the game!", sender);
					} else {
						
						sendMessage(ChatColor.RED + "You are not in a game!", sender);
					}
					
				} else if (args[0].equalsIgnoreCase("setlobby")) {
					
					lobby.setLobby((Player) sender);
			}else {
					sendMessage(ChatColor.RED + "Unknow command. Do /hg help - To get help.",
					        sender);
				}
			} else {
				help.help(sender);
			}
		}

		return false;

	}
	
	public String getPluginName() {
		
		return this.getDescription().getName();
	}

	public void sendMessage(String message, CommandSender sender) {

		sender.sendMessage(sendMessage + message);
	}
	
	public HungerGames getInstance() {
		
		return this;
	}
}
