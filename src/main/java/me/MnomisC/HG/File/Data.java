package main.java.me.MnomisC.HG.File;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import main.java.me.MnomisC.HG.HungerGames;

public class Data {

	HungerGames hg = new HungerGames();
	File dataFile;
	public FileConfiguration data;

	public void initializeFiles() {

		dataFile = new File(hg.getDataFolder(), "data.yml");
		
		try {
			firstRun();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		data = new YamlConfiguration();

		load();
	}
	
	private void firstRun() throws Exception {
		if (!dataFile.exists()) {
			dataFile.getParentFile().mkdir();
			copy(this.getClass().getResourceAsStream("data.yml"), dataFile);
		}
	}
	
	private void copy(InputStream in, File file) {
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
