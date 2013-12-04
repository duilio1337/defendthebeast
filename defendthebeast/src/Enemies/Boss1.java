package Enemies;

import bullets.BossBullet1;
import bullets.Bullet;
import jgame.ImageCache;
import dtb.Defend;

public class Boss1 extends Boss {

	public Boss1() {
		super(ImageCache.forClass(Defend.class).get("Bosses/URGhast.png"),5000, 5000);
	}

	@Override
	public double getSlowness() { return 20; }

	@Override
	public double getFireRange() { return 100; }

	@Override
	public int getFireDelay() { return 100; }

	@Override
	public int getFireCoolDown() { return 100; }

	@Override
	public double getBulletSpeed() { return 100; }

	@Override
	public Bullet createBullet() { return new BossBullet1(); }
}