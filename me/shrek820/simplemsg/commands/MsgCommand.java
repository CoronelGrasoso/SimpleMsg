package me.shrek820.simplemsg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.shrek820.simplemsg.SimpleMsg;
import me.shrek820.simplemsg.Utils;

public class MsgCommand implements CommandExecutor{
	
	SimpleMsg plugin;
	
	public MsgCommand(SimpleMsg plugin) {
		
		this.plugin = plugin;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		FileConfiguration config = plugin.getConfig();
		
		if (!(sender instanceof Player)) {
			
			Bukkit.getConsoleSender().sendMessage(plugin.name + " " + Utils.color(config.getString("Config.cant-execute-commands-at-console")));
			
			return true;
			
		}else {
			
			Player player = (Player) sender;
			
			if (args.length > 1) {
				
				Player toSend = Bukkit.getPlayer(args[0]);
				
				if (toSend != null) {
					
					String msg = "";
					
					for (int i = 1; i < args.length; i++) {
						
						msg = msg + " " + args[i];
						
					}
					
					player.sendMessage(plugin.name + Utils.color(" &a&l" + player.getName() + ":" + msg + " -> " + toSend.getName()));
					
					toSend.sendMessage(plugin.name + Utils.color(" &c&l" + player.getName() + ":" + msg));
					
					return true;
					
				}
				
				return true;
				
			}else {
				
				player.sendMessage(plugin.name + " " + Utils.color(config.getString("Config.msg-command-usage")));
				
				return true;
				
			}
			
		}
		
	}
	
}
