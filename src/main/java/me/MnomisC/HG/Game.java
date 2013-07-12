package main.java.me.MnomisC.HG;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Game {
	
	HungerGames hg;
	HashMap<Player, String> players = new HashMap<Player, String>();
	
	public void joinGame(Player player) {
		
		players.put(player, "lol");
		hg.sendMessage(ChatColor.GREEN + "Succesfully joined the game!", player);
	}
}
