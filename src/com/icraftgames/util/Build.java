package com.icraftgames.util;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.icraftgames.main.Paste;

public class Build implements Listener{
	
	public static void BuildStructre(Location loc, Player player, String file) {
		String fileready = null;
		if(file.equalsIgnoreCase("RAILS")) {
			fileready = "storage1.schematic";
		}else {
			return;
		}
		//Snaps the position
		player.sendMessage(loc.getX() + " | " + loc.getY() + " | " + loc.getZ());
		Location snap1 = grid(loc);
		Location snap = new Location(snap1.getWorld(), snap1.getX(), snap1.getY()+2, snap1.getZ());
		player.sendMessage(snap.getX() + " | " + snap.getY() + " | " + snap.getZ());
		
		//Try and Catch to paste the object
		
		try {
			Paste.paste(snap, fileready);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void UpgradeStructre() {
		
	}
	
	public static Location grid(Location loc1) {	
		Location loc = new Location(loc1.getWorld(), loc1.getX(), loc1.getY()-2, loc1.getZ());
		if(loc.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
			return loc;
		}else if(loc.getBlock().getType().equals(Material.GOLD_BLOCK)) {
			//We need to add to Z
			Location z1loc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()+1);
			if(z1loc.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
				return z1loc;
			}else {
				Location z2loc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()+2);
				return z2loc;
			}
				
		}else if(loc.getBlock().getType().equals(Material.IRON_BLOCK)) {
			//We need to subtract to X
			Location x1loc = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ());
			if(x1loc.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
				return x1loc;
			}else {
				Location x2loc = new Location(loc.getWorld(), loc.getX()-2, loc.getY(), loc.getZ());
				return x2loc;
			}
		}else if(loc.getBlock().getType().equals(Material.EMERALD_BLOCK)) {
			//We need to add to Z
			Location z1loc = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ()+1);
			if(z1loc.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
				return z1loc;
			}else {
				Location x1loc = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ()+2);
				return x1loc;
			}
		}else if(loc.getBlock().getType().equals(Material.REDSTONE_BLOCK)) {
			//We need to add to Z
			Location x1loc = new Location(loc.getWorld(), loc.getX()-2, loc.getY(), loc.getZ()+1);
			if(x1loc.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
				return x1loc;
			}else {
				Location x2loc = new Location(loc.getWorld(), loc.getX()-2, loc.getY(), loc.getZ()+2);
				return x2loc;
			}
		}
			
		return loc;
	}

}
