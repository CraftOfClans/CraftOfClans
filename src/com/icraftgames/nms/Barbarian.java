package com.icraftgames.nms;

import net.minecraft.server.v1_7_R4.EntityZombie;
import net.minecraft.server.v1_7_R4.World;

public class Barbarian extends EntityZombie {

	public Barbarian(World world) {
		super(world);
		
		this.goalSelector.a(0, new PathfinderGoalWalkToLoc(null, null, bh));
	}
	
	
	
	

}
