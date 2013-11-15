package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy1 extends Enemy{

	public Enemy1() {
		super(ImageCache.forClass(Defend.class).get("Enemies/Zombie.png"),100);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

}
