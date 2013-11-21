package Enemies;

import bullets.BossBullet1;
import bullets.Bullet;
import jgame.ImageCache;
import dtb.Defend;

public class Boss1 extends Boss {

	public Boss1() {
		super(ImageCache.forClass(Defend.class).get("Bosses/URGhast.png"),5000);
	}

	@Override
	public double getSlowness() { return 10; }

	@Override
	public double getFireRange() { return 10; }

	@Override
	public int getFireDelay() { return 10; }

	@Override
	public int getFireCoolDown() { return 10; }

	@Override
	public double getBulletSpeed() { return 10; }

	@Override
	public Bullet createBullet() { return new BossBullet1(); }
}