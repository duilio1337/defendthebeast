package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Boss1 extends Boss {

	public Boss1() {
		super(ImageCache.forClass(Defend.class).get("Bosses/URGhast.png"),500);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 0;
	}
}