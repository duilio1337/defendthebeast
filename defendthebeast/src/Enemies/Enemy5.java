package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy5 extends Enemy {

	public Enemy5() {
		super(ImageCache.forClass(Defend.class).get("Enemies/Slime.png"),20);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 0;
	}

}
