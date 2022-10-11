package me.shrek820.simplemsg;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.shrek820.simplemsg.commands.MsgCommand;

public class SimpleMsg extends JavaPlugin{
	
	String pathConfig;
	
	public String name = ChatColor.AQUA + "[" + Utils.color(this.getConfig().getString("Config.prefix")) + ChatColor.AQUA + "]";
	
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.WHITE + " Plugin activated");
		
		registerConfig();
		
		registerCommands();
		
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
	
	public void registerCommands() {
		
		this.getCommand("msg").setExecutor(new MsgCommand(this));
		
	}
	
}
