package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy2 extends Enemy{

	public Enemy2() {
		super(ImageCache.forClass(Defend.class).get("Enemies/Skeleton.png"),150, 15);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
