package main.java.me.MnomisC.HG;

import java.util.HashMap;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Game {

	HungerGames hg;
	HashMap<Player, String> players = new HashMap<Player, String>();

	public Boolean joinGame(CommandSender sender) {
		
		if (!players.containsKey((Player) sender)) {
			
			players.put((Player) sender, "lol");
			return true;

		} else {
			
			return false;
		}
	}
	
	public boolean leaveGame(CommandSender sender) {
		
		if (players.containsKey((Player) sender)) {
			
			players.remove((Player) sender);
			return true;
		} else {
			
			return false;
		}
	}
}
