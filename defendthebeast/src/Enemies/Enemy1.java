package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy1 extends Enemy {

	public Enemy1(int[] x, int[] y) {
		super(ImageCache.forClass(Defend.class).get("Enemies/Zombie.png"), 100,
				10, x, y);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
