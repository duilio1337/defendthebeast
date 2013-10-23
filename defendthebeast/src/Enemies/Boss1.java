package Enemies;

import jgame.ImageCache;
import dtb.Defend;

public class Boss1 extends Boss {

	public Boss1() {
		super(ImageCache.forClass(Defend.class).get("URGhast.png"));
	}
}