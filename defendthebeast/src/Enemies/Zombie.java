package Enemies;

import java.awt.Image;

import jgame.GSprite;
import jgame.ImageCache;
import dtb.Defend;

public class Zombie extends Enemy{

	public Zombie(Image image) {
		super(ImageCache.forClass(Defend.class).get("skull_zombie.png"));
	}

}
