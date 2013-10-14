package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy3 extends Enemy{

	public Enemy3() {
		super(ImageCache.forClass(Defend.class).get("skull_creeper.png"));
	}

}
