package main.java.me.MnomisC.HG;

import org.bukkit.command.CommandSender;

public class Help {

	String[] adminHelp = { "/hg random - Is awesome", "/hg LOL - dasjjsadj" };

	public void admin(CommandSender sender, int page) {

		if (page < adminHelp.length) {

			sender.sendMessage("----------[Help - Page " + page + " of " + adminHelp.length + "]");
			for (int i = 0; i < 10; i++) {

				sender.sendMessage(adminHelp[i]);
			}
		}
	}
}
