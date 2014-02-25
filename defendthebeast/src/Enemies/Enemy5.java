package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy5 extends Enemy {

	public Enemy5(int[] x, int[] y) {
		super(ImageCache.forClass(Defend.class).get("Enemies/Slime.png"), 350,
				50, x, y);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
