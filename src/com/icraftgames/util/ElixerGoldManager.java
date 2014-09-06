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
	
	public static int getGold() {
		return 5;
	}
	
	public static int getElixir() {
		return 5;
	}
	
	public static void setUp() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("dummy", "dummy");
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		objective.setDisplayName("Money");
		
		for(Player online : Bukkit.getOnlinePlayers()) {
			online.setScoreboard(board);
			
			@SuppressWarnings("deprecation")
			Score Elixer = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_PURPLE + "Elixer: " ));
			Elixer.setScore(getElixir());
			
			@SuppressWarnings("deprecation")
			Score Gold = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "Gold:"));
			Gold.setScore(getGold());
			
		}
	}
}
