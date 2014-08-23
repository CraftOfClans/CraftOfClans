package com.icraftgames.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.World;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;






public class SchematicManager {

	
	@SuppressWarnings({ "unused", "deprecation" })
	private void loadSchematic(World world, File file, com.sk89q.worldedit.Vector origin) throws DataException, IOException, MaxChangedBlocksException
    {
        EditSession es = new EditSession(new BukkitWorld(world), 999999999);
        CuboidClipboard cc = CuboidClipboard.loadSchematic(file);
        cc.paste(es, origin, false);
    }
 

}