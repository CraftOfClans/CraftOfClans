package com.icraftgames.nms;

import net.minecraft.server.v1_7_R4.EntityInsentient;
import net.minecraft.server.v1_7_R4.Navigation;
import net.minecraft.server.v1_7_R4.PathEntity;
import net.minecraft.server.v1_7_R4.PathfinderGoal;

import org.bukkit.Location;

public class PathfinderGoalWalkToLoc extends PathfinderGoal 	{
	
	
	   private double speed;

	   private EntityInsentient entity;

	   private Location loc;

	   private Navigation navigation;

	   public PathfinderGoalWalkToLoc(EntityInsentient entity, Location loc, double speed)
	   {
	     this.entity = entity;
	     this.loc = loc;
	     this.navigation = this.entity.getNavigation();
	     this.speed = speed;
	   }


	
	public boolean a() {
		
		return true;
	}
	
	public void c() {
		PathEntity pathEntity = this.navigation.a(loc.getX(), loc.getY(), loc.getZ());
		
		this.navigation.a(pathEntity, speed);
	}
	

}
