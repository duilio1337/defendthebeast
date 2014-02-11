package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy3 extends Enemy{

	public Enemy3(int[] x, int[] y) {
		super(ImageCache.forClass(Defend.class).get("Enemies/Creeper.png"),200, 20, x, y);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
