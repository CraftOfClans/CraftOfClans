package com.icraftgames.util;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UIManager {
	
	@SuppressWarnings("deprecation")
	public Block getLookingAt(Player p) {
		   Block b = p.getTargetBlock(null, 200);
		   return b;
	}
	
	public Boolean is(Material material, Location loc) {
		if(loc.getBlock().getType().equals(material)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void giveItem(Player player, Material item, int slot,  String name, String lore) {
		ItemStack itemStack = new ItemStack(item);
		player.getInventory().setItem(slot, itemStack);
	}
	
	public static void giveItemName(Player player, Material item, int slot, String name, String lore) {
		ItemStack itemStack = new ItemStack(item);
		ItemMeta itemStackMeta = itemStack.getItemMeta();
		itemStackMeta.setDisplayName(name);
		itemStack.setItemMeta(itemStackMeta);
		player.getInventory().setItem(slot, itemStack);
	}

	
	
}