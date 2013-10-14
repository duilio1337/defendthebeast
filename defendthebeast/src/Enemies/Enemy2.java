package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy2 extends Enemy{

	public Enemy2() {
		super(ImageCache.forClass(Defend.class).get("skull_skeleton.png"));
	}

}
