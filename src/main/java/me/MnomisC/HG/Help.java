package main.java.me.MnomisC.HG;

import org.bukkit.command.CommandSender;

public class Help {

	String[] adminHelp = { "/hg help - To get this screen", "/hg join - To get to main lobby"};
	int pages = 1;

	public void help(CommandSender sender) {

		sender.sendMessage("----------[Help]----------");
		for (int i = 0; i < adminHelp.length; i++) {

			sender.sendMessage(adminHelp[i]);
		}
	}
}
