package com.icraftgames.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ElixerGoldManager {
	public static ScoreboardManager manager = Bukkit.getScoreboardManager();
	public static Scoreboard board = manager.getNewScoreboard();
	public static Objective objective = board.registerNewObjective("dummy", "dummy");
	
	
	public static int getGold() {
		return 5;
	}
	
	public static int getElixir() {
		return 5;
	}
	
	public static void setUp() {
		
		
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		objective.setDisplayName("Money");
		
		
	}
	
	public void playerSetUp(Player p) {
		p.setScoreboard(board);
		
		@SuppressWarnings("deprecation")
		Score Elixer = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_PURPLE + "Elixer: " ));
		Elixer.setScore(getElixir());
		
		@SuppressWarnings("deprecation")
		Score Gold = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Gold:"));
		Gold.setScore(getGold());
		
	}
}
