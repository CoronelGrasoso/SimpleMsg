package me.shrek820.simplemsg;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMsg extends JavaPlugin{
	
	Utils utils = new Utils();
	
	String pathConfig;
	
	String name = ChatColor.AQUA + "[" + utils.color(this.getConfig().getString("Config.prefix")) + ChatColor.AQUA + "]";
	
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " Plugin activated");
		
		registerConfig();
		
	}
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " Plugin deactivated");
		
	}
	
	public void registerConfig() {
		
		File config = new File(this.getDataFolder(), "config.yml");
		
		pathConfig = config.getPath();
		
		if (!config.exists()) {
			
			this.getConfig().options().copyDefaults(true);
			saveConfig();
			
		}
		
	}
	
}
