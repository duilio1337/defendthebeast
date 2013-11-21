package bullets;

import jgame.ImageCache;
import dtb.Defend;

public class BossBullet1 extends Bullet {
	public BossBullet1() {
		super(ImageCache.forClass(Defend.class).get("Bullets/fireball.png"), 15, "Turret");
	}
}
