package com.icraftgames.manage;

/*import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;*/

import org.bukkit.event.Listener;

import com.icraftgames.main.CraftOfClans;

public class onJoin implements Listener{
	
	public static CraftOfClans plugin;
	
	//@EventHandler
	/*public void onJoin(PlayerJoinEvent ev) {
		Player p = ev.getPlayer();
		p.setMaxHealth(0.1);
		
		
	    for(Player p1 : Bukkit.getOnlinePlayers()) {
	    	plugin.getConfig().set(p1.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
	    }
		
		
		UIManager.giveItemName(p, Material.GOLD_BLOCK, 1, "Interact", "Interact with buildings!");
		UIManager.giveItemName(p, Material.DIAMOND_BLOCK, 2, "Menu", "Use COC>Commands!");
		UIManager.giveItemName(p, Material.EMERALD, 8, "Shop", "Buy structres!");
		UIManager.giveItemName(p, Material.NETHER_STAR, 4, "--->", "Buy structres!");
		if(plugin.getConfig().getString(p.getName().toLowerCase() + ".tempSelected") == "none") {
			UIManager.giveItemName(p, Material.WOOL, 5, "No Structres Selected", "Go to the shop to add structres!");
		}else {
			UIManager.giveItemName(p, Material.WOOL, 5, plugin.getConfig().getString(p.getName().toLowerCase() + ".tempSelected"), "Right click or place the block to create!");
		}
		UIManager.giveItemName(p, Material.NETHER_STAR, 6, "<---", "Buy structres!");
		
		UIManager.giveItemName(p, Material.IRON_FENCE, 0, ChatColor.RED + "" + ChatColor.BOLD + "null", "null");
		UIManager.giveItemName(p, Material.IRON_FENCE, 3, ChatColor.RED + "" + ChatColor.BOLD + "null", "null");
		UIManager.giveItemName(p, Material.IRON_FENCE, 7, ChatColor.RED + "" + ChatColor.BOLD + "null", "null");
		
		ItemStack itemStack = new ItemStack(Material.IRON_FENCE);
		ev.getPlayer().getInventory().setItem(0, itemStack);
	}*/
}
