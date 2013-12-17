package bullets;

import jgame.ImageCache;
import dtb.Defend;

public class Bullet5 extends Bullet {

	public Bullet5() {
		super(ImageCache.forClass(Defend.class).get("Bullets/fireball.png"), 1000, "Enemy");
		// TODO Auto-generated constructor stub
	}

}
