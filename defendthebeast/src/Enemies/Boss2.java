package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Boss2 extends Boss {

	public Boss2() {
		super(ImageCache.forClass(Defend.class).get("Bosses/Pony.png"), 400);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 0;

	}
}
