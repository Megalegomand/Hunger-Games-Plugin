package main.java.me.MnomisC.HG;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Minecraft");
	public static HungerGames plugin;
	public Help help = new Help();

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
			if (args[0].equalsIgnoreCase("help")) {
				if (sender.hasPermission("hungergames.admin") || sender.isOp()
				        || sender instanceof ConsoleCommandSender) {
					if (args.length == 2) {
						help.admin(sender, Integer.parseInt(args[1]));
					} else {
						help.admin(sender, 1);
					}
				}
			}
		}

		return false;

	}
}
