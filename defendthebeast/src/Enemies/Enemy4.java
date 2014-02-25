package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy4 extends Enemy {

	public Enemy4(int[] x, int[] y) {
		super(ImageCache.forClass(Defend.class).get("Enemies/Blaze.png"), 300,
				30, x, y);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
