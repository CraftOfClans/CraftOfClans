package com.icraftgames.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftOfClans extends JavaPlugin implements Listener { 
	
	
	public void onEnable() {
		
	  getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		
		Player p = ev.getPlayer();
	}
	
	
	
}
