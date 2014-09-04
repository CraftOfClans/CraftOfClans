package com.icraftgames.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.icraftgames.util.*;

public class Paste {
	public static void paste(Location loc, String filename) throws IOException {
		
		//Now we need to instantiate a empty schematic
		Schematic Building = null;
		
		//Now we need to set the Building schematic to the file
		//We will use a try and catch method to catch File exceptions such as no file found
		
		
		try {
			Building = com.icraftgames.util.Schematic.loadSchematic(new File("schematics", filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//So now we have safely loaded our Building schematic
		//Now if we want to paste it, all we have to do is
		com.icraftgames.util.Schematic.pasteSchematic(Bukkit.getWorld("COC"), loc, Building);
	}
}
