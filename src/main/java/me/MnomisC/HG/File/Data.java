package main.java.me.MnomisC.HG.File;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import main.java.me.MnomisC.HG.HungerGames;

public class Data {

	HungerGames hg;
	File dataFile;
	public FileConfiguration data;

	public Data() {
		hg = hg.getInstance();
	}
	
	public void initializeFiles() {

		
		
		dataFile = new File(hg.getDataFolder(), "data.yml");
		
		if (!dataFile.exists()) {
			hg.saveResource("data.yml", false);
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
