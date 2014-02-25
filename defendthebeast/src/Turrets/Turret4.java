package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet4;
import dtb.Defend;

public class Turret4 extends Turret {

	private static int turretCost = 400;

	public Turret4() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand4turret.png"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSound() {
		String Snd;
		double a = (Math.random() * 3);
		if (a < 1) {
			Snd = "light1.wav";
		} else if (a < 2) {
			Snd = "light1.wav";
		} else {
			Snd = "light1.wav";
		}
		return Snd;
	}

	@Override
	public double getFireRange() {
		return 500;
	}

	@Override
	public int getFireDelay() {
		return 10;
	}

	@Override
	public int getFireCoolDown() {
		return 10;
	}

	@Override
	public int getFireCost() {
		return 10;
	}

	@Override
	public double getBulletSpeed() {
		return 10;
	}

	@Override
	public Bullet createBullet() {
		return new Bullet4();
	}

	public static int getCost() {
		return turretCost;
	}

	@Override
	public int getTurretCost() {
		return turretCost;
	}

}
