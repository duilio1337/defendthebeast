package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Boss2 extends Boss {

	public Boss2() {
		super(ImageCache.forClass(Defend.class).get("Bosses/Boss2.png"), 10000, 500);
	}

	@Override
	public double getSlowness() {return 25;}
}
