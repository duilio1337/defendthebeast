package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Boss1 extends Boss {

	public Boss1() {
		super(ImageCache.forClass(Defend.class).get("Bosses/URGhast.png"),5000, 5000);
	}

	@Override
	public double getSlowness() { return 20; }
}