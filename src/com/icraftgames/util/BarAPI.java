package com.icraftgames.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class BarAPI {
	
	public void sapwnBar() {
		
	}
	/* 5Lengths .. For each 5 lengths do stuff*/
	@SuppressWarnings({ "deprecation", "unused" })
	public static void setBar(Location origin, int length, int height) {
		//origin.getBlock().setTypeIdAndData(35, (byte) 5, true);
		
		Location loc10 = new Location(Bukkit.getWorld("COC"), origin.getX()+10, origin.getY(), origin.getZ());
		int currentlength = 0;
		while(currentlength <= length) {
			currentlength = currentlength + 1;
			Location temloc = new Location(Bukkit.getWorld("COC"), origin.getX()-currentlength, origin.getY()+10, origin.getZ());
			temloc.getBlock().setTypeIdAndData(35, (byte) 5, true);
			//for each length we want to add onto the lengthtest (int) 
			// i have an idea wait could we just increment it by ++
		}
		int currentheight = 0;
		currentlength = 0;
		while(currentheight <= height) {
			currentheight = currentheight + 1;

			while(currentlength <= length) {
				currentlength = currentlength + 1;
				Location temloc = new Location(Bukkit.getWorld("COC"), origin.getX()-currentlength, origin.getY()+10+currentheight, origin.getZ());
				temloc.getBlock().setTypeIdAndData(35, (byte) 5, true);
			}
		}
		
	}
}
