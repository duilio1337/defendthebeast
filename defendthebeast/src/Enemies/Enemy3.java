package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy3 extends Enemy{

	public Enemy3() {
		super(ImageCache.forClass(Defend.class).get("Enemies/Creeper.png"),20);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 0;
	}

}
