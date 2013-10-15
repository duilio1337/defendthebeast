package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Enemy1 extends Enemy{

	public Enemy1() {
		super(ImageCache.forClass(Defend.class).get("Zombie.png"));
	}

}
