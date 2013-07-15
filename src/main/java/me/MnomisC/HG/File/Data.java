package main.java.me.MnomisC.HG.File;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import main.java.me.MnomisC.HG.HungerGames;

public class Data {

	Plugin plugin;
	File dataFile;
	public FileConfiguration data;
	
	public Data(Plugin plugin) {
		
		this.plugin = plugin;
	}
	
	public void initializeFiles() {
		
		dataFile = new File(this.plugin.getDataFolder(), "data.yml");
		
		if (!dataFile.exists()) {
			this.plugin.saveResource("data.yml", false);
		}
		
		data = new YamlConfiguration();

		load();
	}
	
	public void load() {
		try {
			data.load(dataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			data.save(dataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Data getInstance() {
		
		return this;
	}
}
