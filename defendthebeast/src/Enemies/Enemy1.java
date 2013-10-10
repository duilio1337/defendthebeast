package Enemies;

import java.awt.Image;

import jgame.GSprite;
import jgame.ImageCache;
import dtb.Defend;

public class Enemy1 extends Enemy{

	public Enemy1(Image image) {
		super(ImageCache.forClass(Defend.class).get("skull_zombie.png"));
	}

}
