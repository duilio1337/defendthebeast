package bullets;

import jgame.ImageCache;
import dtb.Defend;

public class Bullet2 extends Bullet {

	public Bullet2() {
		super(ImageCache.forClass(Defend.class).get("Bullets/arrow_fix.png"), 10, "Enemy");
		// TODO Auto-generated constructor stub
	}

}
