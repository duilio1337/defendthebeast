package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy4 extends Enemy {

	public Enemy4() {
		super(ImageCache.forClass(Defend.class).get("Enemies/Blaze.png"),300, 30);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 10;
	}

}
