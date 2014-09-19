package com.icraftgames.util;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GridSnap {
	
	public static void placeObject(Location loc, Player player) {
		
		if(loc.getBlock().getType().equals(Material.STONE)) {
		}
		
		if(loc.getBlock().getType().equals(Material.COBBLESTONE)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (player.getWorld(), x+1, y+2, z);
			player.sendMessage("YAY! IT WORKS!");
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.LOG)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x+2, y+2, z);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.WOOL)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x, y+2, z-1);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.GOLD_BLOCK)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x+1, y+2, z-1);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x+2, y+2, z-1);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.IRON_BLOCK)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x, y+2, z-2);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.BEDROCK)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x+1, y+2, z-2);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
		if(loc.getBlock().getType().equals(Material.COAL_BLOCK)) {
			double x = loc.getX();
			double y = loc.getX();
			double z = loc.getX();
			Location locnew = new Location (Bukkit.getWorld("COC"), x+3, y+2, z-3);
			player.getWorld().getBlockAt(locnew).setType(Material.OBSIDIAN);
		}
		
	}


}
