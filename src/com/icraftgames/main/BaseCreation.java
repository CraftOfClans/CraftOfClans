package com.icraftgames.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.icraftgames.util.ConfigManager;
import com.icraftgames.util.SchematicManager;


public class BaseCreation {
	
	
	public void createBase(Player player) {
		
		if(ConfigManager.get("TempBase.yml") != null) {
			
		}else {
			ConfigManager.load("TempBase.yml");
		}
		//Gets latest base created
		int x = getConfig().getInt("base.x");
		int x1 = getConfig().getInt("base.x1");
		
		//Y default axis base placement
		int y = 25;
		//Z default axis base placement
		int z = 25;
		
		//Size in width
		int a = 50;
		//Size in-between basses
		int b = 25;
		
		int Xnew = x+b+a;
		int X1new = x1+b+a;
		
		/* //Creates Xnew and X1new into a location for teleporting and schematic placing.
		Location Loc_Xnew = new Location(player.getLocation().getWorld(), Xnew, y, z);
		Location Loc_X1new = new Location(player.getLocation().getWorld(), X1new, y, z);
		
		//Just for debug to see where it places the new base!
		Loc_Xnew.getBlock().setType(Material.GOLD_BLOCK);
		Loc_X1new.getBlock().setType(Material.DIAMOND_BLOCK); */
		
		
		SchematicManager schematic;
		Location origin;
		
		String path = "Path.To.Schematic";
		
		
		try {
		schematic = SchematicManager.load(new File(path));
		} catch (Exception ex) {
			Bukkit.getLogger().severe("Failed to load schematic: " + ex.getMessage());
		}
		
		if(schematic != null) {
			schematic.paste(Bukkit.getWorld("world"), origin);
		}
		
		
		
		//Saves newest location to currently created location
		getConfig().set("base.x", Integer.valueOf(Xnew));
		getConfig().set("base.x1", Integer.valueOf(X1new));
		saveConfig();
		
		//Teleports and gives message
		
		player.sendMessage(ChatColor.GREEN + "Base created successfully");

	}

}
