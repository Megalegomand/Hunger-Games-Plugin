package main.java.me.MnomisC.HG;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Minecraft");
	public static HungerGames plugin;
	public Help help = new Help();
	public Game game = new Game();
	public String sendMessage = ChatColor.AQUA + "[" + ChatColor.GOLD + "HungerGames"
	        + ChatColor.AQUA + "] " + ChatColor.WHITE;

	@Override
	public void onDisable() {

		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + "has been disabled");
	}

	@Override
	public void onEnable() {

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
					
				} else {
					sendMessage(ChatColor.RED + "Unknow command. Do /hg help - To get help.",
					        sender);
				}
			} else {
				help.help(sender);
			}
		}

		return false;

	}

	public void sendMessage(String message, CommandSender sender) {

		sender.sendMessage(sendMessage + message);
	}
}
