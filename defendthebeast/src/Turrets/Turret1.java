package Turrets;

import jgame.Context;
import jgame.GObject;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.listener.DelayListener;
import bullets.Bullet;
import bullets.Bullet1;
import dtb.Defend;

public class Turret1 extends Turret {
	
	private static int turretCost = 100;

	public Turret1() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand1turret.png"));
		// TODO Auto-generated constructor stub
	}
	
	public void fireBullet() {
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		int rand=(int)(Math.random()*60)-30;
		final ConstantMovementController cmc = ConstantMovementController.createPolar(getBulletSpeed(), getRotation()+rand);
		DelayListener dl = new DelayListener(5) {

			@Override
			public void invoke(GObject target, Context context) {
				cmc.setDamping(1.1);
				b.addController(cmc);

			}
		};
		b.addListener(dl);
		snapAnchor(b);
		b.moveAtAngle(getWidth() / 2 + 20, getRotation());
		this.addSibling(b);

	}
	
	public String getSound(){
		return "fireloop.wav";
	}
	
	public double getFireRange() {
		return 400;
	}

	public int getFireDelay() {
		return 10;
	}
	
	public int getFireCost() {
		return 10;
	}

	public int getFireCoolDown() {
		return 0;
	}

	public double getBulletSpeed() {
		return 7;
	}

	public Bullet createBullet() {
		return new Bullet1();
	}
	
	public static int getCost() {
		return turretCost;
	}
	
	public int getTurretCost() {
		return turretCost;
	}
}
