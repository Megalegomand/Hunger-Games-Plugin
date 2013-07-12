package main.java.me.MnomisC.HG;

import org.bukkit.command.CommandSender;

public class Help {

	String[] adminHelp = { "/hg random - Is awesome", "/hg LOL - dasjjsadj" };
	int pages = 1;

	public void admin(CommandSender sender, int page) {

		if (page < pages) {
			
			sender.sendMessage("----------[Help - Page " + page + " of " + pages + "]");
			for (int i = 0; i < adminHelp.length; i++) {

				sender.sendMessage(adminHelp[i]);
			}
		}
	}
}
