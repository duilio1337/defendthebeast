package bullets;

import jgame.ImageCache;
import dtb.Defend;

public class Bullet4 extends Bullet {

	public Bullet4() {
		super(ImageCache.forClass(Defend.class).get("Bullets/pure.png"), 1.5,
				Behavior.PIERCING);
		// TODO Auto-generated constructor stub
	}

}
