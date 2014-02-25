package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet5;
import dtb.Defend;

public class Turret5 extends Turret {

	private static int turretCost = 500;

	public Turret5() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand5turret.png"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSound() {
		return "fireball1.wav";
	}

	@Override
	public double getFireRange() {
		return 300;
	}

	@Override
	public int getFireDelay() {
		return 5;
	}

	@Override
	public int getFireCoolDown() {
		return 100;
	}

	@Override
	public int getFireCost() {
		return 100;
	}

	@Override
	public double getBulletSpeed() {
		return 6;
	}

	@Override
	public Bullet createBullet() {
		return new Bullet5();
	}

	public static int getCost() {
		return turretCost;
	}

	@Override
	public int getTurretCost() {
		return turretCost;
	}

}
