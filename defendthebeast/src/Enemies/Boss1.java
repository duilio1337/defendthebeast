package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Boss1 extends Boss {

	public Boss1(int[] x, int[] y) {
		super(ImageCache.forClass(Defend.class).get("Bosses/URGhast.png"),5000, 250, x, y);
	}

	@Override
	public double getSlowness() { return 20; }
}