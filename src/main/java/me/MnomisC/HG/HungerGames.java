package main.java.me.MnomisC.HG;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Minecraft");
	public static HungerGames plugin;
	public Help help = new Help();
	public Game game = new Game();

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
					game.joinGame((Player) sender);
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

		sender.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "HungerGames" + ChatColor.AQUA
		        + "] " + ChatColor.WHITE + message);
	}
}
