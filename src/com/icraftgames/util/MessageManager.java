package com.icraftgames.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageManager {

	private MessageManager(){}
	private static MessageManager instance = new MessageManager();
	public static MessageManager getInstance(){
		return instance;
	}
	
	private String ptag = ChatColor.GRAY + "[" + ChatColor.GOLD + "CraftOfClans" + ChatColor.GRAY + "]";
	
	public void good(CommandSender sender, boolean tags, String... msgs){
		if(tags){
			msg(sender, ChatColor.GREEN, msgs);
		} else msg_notags(sender, ChatColor.GREEN, msgs);
	}

	public void bad(CommandSender sender, boolean tags, String... msgs){
		if(tags){
			msg(sender, ChatColor.RED, msgs);
		} else msg_notags(sender, ChatColor.GREEN, msgs);
	}

	public void info(CommandSender sender, boolean tags, String... msgs){
		if(tags){
			msg(sender, ChatColor.AQUA, msgs);
		} else msg_notags(sender, ChatColor.GREEN, msgs);
	}
	
	private void msg(CommandSender sender, ChatColor color, String... msg){
		sender.sendMessage(ptag);
		for(String s : msg){
			sender.sendMessage(color + s);
		}
		sender.sendMessage(ptag);
	}
	private void msg_notags(CommandSender sender, ChatColor color, String... msg){
		for(String s : msg){
			sender.sendMessage(color + s);
		}
	}
	
		
	
}