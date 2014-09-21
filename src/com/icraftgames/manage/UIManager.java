package com.icraftgames.manage;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.icraftgames.util.GetTargetBlock;

public class UIManager {
	
	public Block getLookingAt(Player p) {
		   Block b = GetTargetBlock.getTargetBlock(p, 200);
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
	
	public static Inventory Shop = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		createDisplay(Material.DIAMOND_BLOCK, Shop, 0, "Treasure", "Buy Gems, Gold, Elixir, and MORE!");
		createDisplay(Material.GOLD_INGOT, Shop, 1, "Resources", "Buy resource structres!");
		createDisplay(Material.FLOWER_POT_ITEM, Shop, 2, "Decorations", "Buy decorations!");
		createDisplay(Material.IRON_SWORD, Shop, 3, "Army", "Buy army related structres!");
		createDisplay(Material.TNT, Shop, 4, "Defense", "Buy things to defend your base!");
		createDisplay(Material.SIGN, Shop, 5, "Shield", "Buy shields to not get attacked!");
	}
	
	public static Inventory MenuDefense = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.ANVIL, MenuDefense, 0, "Cannon", "//Add Stats here");
		UIManager.createDisplay(Material.FENCE, MenuDefense, 1, "Walls", "//Add Stats here");
		UIManager.createDisplay(Material.ANVIL, MenuDefense, 0, "Cannon", "//Add Stats here");
		UIManager.createDisplay(Material.ANVIL, MenuDefense, 0, "Cannon", "//Add Stats here");
		UIManager.createDisplay(Material.ANVIL, MenuDefense, 0, "Cannon", "//Add Stats here");
	}
	
	
	public static Inventory MenuResourceGoldmine1 = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.GOLD_INGOT, MenuResourceGoldmine1, 0, "Collect", "Gold: #");
		UIManager.createDisplay(Material.ANVIL, MenuResourceGoldmine1, 1, "Upgrade", "//Add Stats here");
		UIManager.createDisplay(Material.DIAMOND, MenuResourceGoldmine1, 2, "Boost (72Hour)", "//Add Stats here");
	}
	
	public static Inventory MenuTreasure = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.GOLD_NUGGET, MenuTreasure, 0, "150 Gems", "$2.00");
		UIManager.createDisplay(Material.GOLD_NUGGET, MenuTreasure, 1, "300 Gems", "$4.00");
		UIManager.createDisplay(Material.GOLD_NUGGET, MenuTreasure, 2, "500 Gems", "$5.00");
	}
	
	public static Inventory MenuResource = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.BLAZE_ROD, MenuResource, 0, "Builders Hut", "100,000 Gold");
		UIManager.createDisplay(Material.GOLD_NUGGET, MenuResource, 1, "Gold Mine", "150 Elixir");
		UIManager.createDisplay(Material.SNOW, MenuResource, 2, "Elixir Collector", "300 Gold");
		UIManager.createDisplay(Material.RAILS, MenuResource, 3, "Gold Storage", "1,000 Elixir");
		UIManager.createDisplay(Material.POWERED_RAIL, MenuResource, 4, "Elixir Storage", "1,500 Gold");
	}
	
	public static Inventory MenuDecorations = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.WOOL, MenuDecorations, 5, ChatColor.RED + "None", "null");

	}
	
	public static Inventory MenuArmy = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.LOG, MenuArmy, 0, "Baracks", "Stats");
		UIManager.createDisplay(Material.WOOD, MenuArmy, 1, "Army Camp", "Stats");
		UIManager.createDisplay(Material.OBSIDIAN, MenuArmy, 2, "Labatory", "Stats");
	}
	
	public static Inventory MenuShield = Bukkit.createInventory(null, 9, "Inventory!");
	static {	
		UIManager.createDisplay(Material.COAL_ORE, MenuShield, 0, "12 Hour", "Stats");
		UIManager.createDisplay(Material.IRON_ORE, MenuShield, 1, "36 Hour", "Stats");
		UIManager.createDisplay(Material.GOLD_ORE, MenuShield, 2, "72 Hour", "Stats");
		UIManager.createDisplay(Material.DIAMOND_ORE, MenuShield, 3, "1 Week", "Stats");
	}
	
	

	
	public static void createDisplay(Material material, Inventory inv, int Slot, String name, String lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add(lore);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		 
		inv.setItem(Slot, item); 
		 
		}
	
	

	
	
}