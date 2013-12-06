package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet1;
import dtb.Defend;

public class Turret1 extends Turret {

	public Turret1() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand1turret.png"), 500);
		// TODO Auto-generated constructor stub
	}

	public double getFireRange() {
		return 200;
	}

	public int getFireDelay() {
		return 10;
	}

	public int getFireCoolDown() {
		return 10;
	}

	public double getBulletSpeed() {
		return 10;
	}

	public Bullet createBullet() {
		return new Bullet1();
	}
	
	public static int getCost() {
		return 100;
	}
}
