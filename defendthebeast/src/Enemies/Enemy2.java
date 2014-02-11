package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy2 extends Enemy{

	public Enemy2(int[] x, int[] y) {
		super(ImageCache.forClass(Defend.class).get("Enemies/Skeleton.png"),150, 15, x, y);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
