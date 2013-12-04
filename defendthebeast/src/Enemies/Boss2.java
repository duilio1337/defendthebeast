package Enemies;

import bullets.Bullet;
import jgame.ImageCache;
import dtb.Defend;

public class Boss2 extends Boss {

	public Boss2() {
		super(ImageCache.forClass(Defend.class).get("Bosses/Boss2.png"), 10000, 10000);
	}

	@Override
	public double getSlowness() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public double getFireRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFireDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFireCoolDown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBulletSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bullet createBullet() {
		// TODO Auto-generated method stub
		return null;
	}
}
