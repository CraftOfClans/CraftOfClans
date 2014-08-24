package com.icraftgames.nms;

import net.minecraft.server.v1_7_R4.EntityIronGolem;
import net.minecraft.server.v1_7_R4.World;

public class Giant extends EntityIronGolem {

	public Giant(World world) {
		super(world);
		
		this.goalSelector.a(0, new PathfinderGoalWalkToLoc(null, null, bh));
	}
	

}
