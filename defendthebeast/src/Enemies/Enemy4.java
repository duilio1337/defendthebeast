package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy4 extends Enemy {

	public Enemy4() {
		super(ImageCache.forClass(Defend.class).get("skull_wither.png"));
	}

}
