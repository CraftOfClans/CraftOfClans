package com.icraftgames.main;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;



public class BaseCreation {
	
	public static CraftOfClans plugin;
	
	
	public BaseCreation(CraftOfClans plugin){
		this.plugin = plugin;
	}
	
	public static void createBase(Player player) {

		//Gets latest base created
		int x = plugin.getConfig().getInt("base.x");
		int x1 = plugin.getConfig().getInt("base.x1");
		
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
		
		

		plugin.getConfig().set("base.x", Integer.valueOf(Xnew));
		plugin.getConfig().set("base.x1", Integer.valueOf(X1new));
		plugin.saveConfig();
		
		//Teleports and gives message
		
		player.sendMessage(ChatColor.GREEN + "Base created successfully");

	}

}
