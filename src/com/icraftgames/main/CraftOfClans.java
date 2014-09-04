package com.icraftgames.main;






import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.icraftgames.util.BarAPI;
import com.icraftgames.util.Build;
import com.icraftgames.util.ChatManager;
import com.icraftgames.util.ElixerGoldManager;
import com.icraftgames.util.GridSnap;
import com.icraftgames.util.UIManager;

public class CraftOfClans extends JavaPlugin implements Listener { 
	
	public Location Cursor;
	public CraftOfClans plugin;
	
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(this, this);
	    registerEvents(this, new ChatManager());
	    registerEvents(this, new Build());
	    List<Player> list = new ArrayList<Player>();
	    
	    for(Player p : Bukkit.getOnlinePlayers()) {
	    	getConfig().set(p.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
	    }
		/*ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objectiveGold = board.registerNewObjective("gold", "dummy");
		Objective objectiveElixir = board.registerNewObjective("Elixir", "dummy");
		objectiveGold.setDisplaySlot(DisplaySlot.SIDEBAR);
		objectiveElixir.setDisplaySlot(DisplaySlot.SIDEBAR);*/
	    
	    ElixerGoldManager.setUp();
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
			}
		}
	
	public void onDisable() {
	
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent ev) {
		Player p = ev.getPlayer();
		p.setMaxHealth(0.1);
		
		
	    for(Player p1 : Bukkit.getOnlinePlayers()) {
	    	getConfig().set(p1.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
	    }
		
		
		UIManager.giveItemName(p, Material.GOLD_BLOCK, 1, "Interact", "Interact with buildings!");
		UIManager.giveItemName(p, Material.DIAMOND_BLOCK, 2, "Menu", "Use COC>Commands!");
		UIManager.giveItemName(p, Material.EMERALD, 8, "Shop", "Buy structres!");
		UIManager.giveItemName(p, Material.NETHER_STAR, 4, "--->", "Buy structres!");
		if(getConfig().getString(p.getName().toLowerCase() + ".tempSelected") == "none") {
			UIManager.giveItemName(p, Material.WOOL, 5, "No Structres Selected", "Go to the shop to add structres!");
		}else {
			UIManager.giveItemName(p, Material.WOOL, 5, getConfig().getString(p.getName().toLowerCase() + ".tempSelected"), "Right click or place the block to create!");
		}
		UIManager.giveItemName(p, Material.NETHER_STAR, 6, "<---", "Buy structres!");
		
		UIManager.giveItemName(p, Material.IRON_FENCE, 0, ChatColor.RED + "" + ChatColor.BOLD + "null", "null");
		UIManager.giveItemName(p, Material.IRON_FENCE, 3, ChatColor.RED + "" + ChatColor.BOLD + "null", "null");
		UIManager.giveItemName(p, Material.IRON_FENCE, 7, ChatColor.RED + "" + ChatColor.BOLD + "null", "null");
		
		ItemStack itemStack = new ItemStack(Material.IRON_FENCE);
		ev.getPlayer().getInventory().setItem(0, itemStack);
	}
	

	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(command.getName().equalsIgnoreCase("create")) {
				player.sendMessage("api");
				BarAPI.setBar(player.getLocation(), 5, 3);
			}else if(command.getName().equalsIgnoreCase("paste")) {
				Build.BuildStructre(player.getLocation(), player, "base.schematic");
			}else if(command.getName().equalsIgnoreCase("createplayer")) {
				getConfig().set("player." + player.getName().toLowerCase() + ".g", Integer.valueOf(1000));
				getConfig().set("player." + player.getName().toLowerCase() + ".e", Integer.valueOf(1000));
			}
		}
		
		return false;
	}

	
	@EventHandler
	public void RightClick(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		boolean mode = getConfig().getBoolean(p.getName().toLowerCase() + ".mode");
		if(event.getAction().toString() == "RIGHT_CLICK_BLOCK") {
			if(p.getItemInHand().getType().equals(Material.EMERALD)) {
				p.openInventory(UIManager.Shop);
				p.sendMessage(ChatColor.GREEN + "You opened the Shop!");
			}else {
				@SuppressWarnings("deprecation")
				Block b = p.getTargetBlock(null, 200);
				final Location loc = b.getLocation();
				if(loc.getBlock().getType().equals(Material.BEACON) && mode) {
					UIManager.giveItemName(p, Material.RAILS, 5, "Gold Mine", "Right click to place!");
					loc.getBlock().setType(Material.AIR);
					p.sendMessage(ChatColor.GREEN + "Building placed!");
					getConfig().set(p.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
					String hand = p.getInventory().getItemInHand().getType().toString();
					Build.BuildStructre(loc, p, hand);
					p.sendMessage(ChatColor.GREEN + "Started build of... " + hand);
					UIManager.giveItemName(p, Material.WOOL, 5, "No Structres Selected", "Go to the shop to add structres!");
					return;
				}else {
					getConfig().set(p.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
					/** Need to set old.**/
					return;
				}
			}
			
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked(); // The player that clicked the item
		
		ItemStack clicked = event.getCurrentItem(); // The item that was clicked
		Inventory inventory = event.getInventory(); // The inventory that was clicked in
		if (inventory.getName().equals(UIManager.Shop.getName())) { // The inventory is our custom Inventory
			if (clicked.getType() == Material.DIAMOND_BLOCK) { // The item that the player clicked it dirt
				event.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				player.openInventory(UIManager.MenuTreasure);
				//Treasure
			}else if (clicked.getType() == Material.GOLD_INGOT) { // The item that the player clicked it dirt
				event.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				player.openInventory(UIManager.MenuResource);
				//Resources
			}else if (clicked.getType() == Material.FLOWER_POT_ITEM) { // The item that the player clicked it dirt
				event.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				player.openInventory(UIManager.MenuDecorations);
				//Decorations
			}else if (clicked.getType() == Material.IRON_SWORD) { // The item that the player clicked it dirt
				event.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				player.openInventory(UIManager.MenuArmy);
				//Army
			}else if (clicked.getType() == Material.TNT) { // The item that the player clicked it dirt
				event.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				player.openInventory(UIManager.MenuDefense);
				//Defense
			}else if (clicked.getType() == Material.SIGN) { // The item that the player clicked it dirt
				event.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				player.openInventory(UIManager.MenuShield);
				//Shield
			}else if(clicked.getType() == Material.BLAZE_ROD) {
				UIManager.giveItemName(player, Material.BLAZE_ROD, 5, "Builder's Hut", "Right click to place!");
				player.closeInventory();
			}else if(clicked.getType() == Material.RAILS) {
				UIManager.giveItemName(player, Material.RAILS, 5, "Gold Mine", "Right click to place!");
				player.closeInventory();
			}else{
				event.setCancelled(true);
			}
		}

	}
	
	@EventHandler
	public void dropitem(PlayerDropItemEvent event) {
		if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			
		}else {
			event.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void placeblock(final BlockPlaceEvent event) {
		final Player p = event.getPlayer();
		if(event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			
		}else if(p.getItemInHand().getType().equals(Material.RAILS)){
			/** Checks if player does not have a mode set, and sets one **/
			
			/** Creates the mode path **/
			boolean mode = getConfig().getBoolean(p.getName().toLowerCase() + ".mode");
			
			/** Create Selection **/
			
			Block b = event.getBlock();
			Location block = b.getLocation();
			Location looking_at = b.getLocation(); Location block_on_grid = new Location(looking_at.getWorld(), looking_at.getX(), 31, looking_at.getZ());
			
			if(mode) {
				/** Already clicked, needs to place if correct **/
				//Block b2 = p.getTargetBlock(null, 200);
				//ocation loc = new Location(b2.getWorld(), b2.getX(), 31, b2.getZ());
				/**if(loc.getBlock().getType().equals(Material.BEACON)) {
					loc.getBlock().setType(Material.AIR);
					p.sendMessage(ChatColor.RED + "Placed!");
					getConfig().set(p.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
					return;
				}else {
					
					getConfig().set(p.getName().toLowerCase() + ".mode", Boolean.valueOf(false));
					p.sendMessage(ChatColor.RED + "Something went wrong, action cancelled: " + loc.getBlock().getType());
					return;
				}**/

				
			}else {
				/** Has not yet clicked **/
				/** Needs to check for block detection **/
				
				
				if(block_on_grid.getBlock().getType().equals(Material.RAILS)) {
					
					/** Block is empty, we need to set it... **/
					event.getBlock().getLocation().getBlock().setType(Material.BEACON);
					
					this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					
						public void run() {
							if(event.getBlock().getType().equals(Material.BEACON)) {
								event.getBlock().setType(Material.AIR);
								p.sendMessage(ChatColor.RED + "Cancelled, action longer than 100 Ticks.");
							}
							
						}
						
					}, 100L);
					
					getConfig().set(p.getName().toLowerCase() + ".mode", Boolean.valueOf(true));
					p.sendMessage(ChatColor.RED + "Right click the " + ChatColor.BLUE + "'Beacon'" + ChatColor.RED +  " again to place!");
					return;
				}else {
					p.sendMessage(ChatColor.RED + "Placement cancelled, isInside block.");
				}
			}
		
		}else {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void Chat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		event.setCancelled(true);
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.GREEN + "" + player.getName().toLowerCase() + ChatColor.GRAY + "   " + event.getMessage());
		}
	}
	
	

	
	
}
