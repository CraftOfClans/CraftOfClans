package com.icraftgames.main;



import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftOfClans extends JavaPlugin implements Listener { 
	
	public Location Cursor;
	
	public void onEnable() {
		
		PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(this, this);
	}
	
	public void onDisable() {
		
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		
		Player p = ev.getPlayer();
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent ev) {
		Player p = ev.getPlayer();
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			
		}
		
		return false;
		
	}
	
	
	
}
