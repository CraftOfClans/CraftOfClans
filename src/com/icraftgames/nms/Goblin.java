package com.icraftgames.nms;

import net.minecraft.server.v1_7_R4.EntitySilverfish;
import net.minecraft.server.v1_7_R4.World;

public class Goblin extends EntitySilverfish {

	public Goblin(World world) {
		super(world);
		
		this.goalSelector.a(0, new PathfinderGoalWalkToLoc(null, null, bh));
	}

}
