package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet3;
import dtb.Defend;

public class Turret3 extends Turret {

	private static int turretCost = 300;

	public Turret3() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand3turret.png"));
		// TODO Auto-generated constructor stub

	}

	@Override
	public String getSound() {
		String Snd;
		double a = (Math.random() * 2);
		if (a < 1) {
			Snd = "shock1.wav";
		} else {
			Snd = "shock2.wav";
		}
		return Snd;
	}

	@Override
	public double getFireRange() {
		return 350;
	}

	@Override
	public int getFireDelay() {
		return 10;
	}

	@Override
	public int getFireCoolDown() {
		return 100;
	}

	@Override
	public int getFireCost() {
		return 10;
	}

	@Override
	public double getBulletSpeed() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Bullet createBullet() {
		return new Bullet3();
	}

	public static int getCost() {
		return turretCost;
	}

	@Override
	public int getTurretCost() {
		return turretCost;
	}

}
