package Turrets;

import java.awt.Image;
import java.util.List;

import dtb.Defend;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.SoundManager;
import jgame.controller.ConstantMovementController;
import jgame.listener.DelayListener;
import jgame.listener.FrameListener;
import Enemies.Enemy;
import Mechanics.Bank;
import Mechanics.HealthBar;
import bullets.Bullet;

public abstract class Turret extends GSprite {
	private boolean placed = false;
	private int timer = 0;
	private boolean fire = true;
	private int fireCoolDown = getFireCoolDown();
	private int bulletsFired = 0;
	private double maxDurablity;
	private double currentDurablity;
	private HealthBar hb = new HealthBar();

	public Turret(Image image) {
		super(image);
		
		this.maxDurablity = 10000;
		currentDurablity = this.maxDurablity;
		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);
		this.addListener(new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {

				if (!placed) {
					return;
				}
				List<Enemy> enemies = context.getInstancesOfClass(Enemy.class);
				double minimumDistance = Integer.MAX_VALUE;
				Enemy closest = null;

				for (Enemy e : enemies) {
					double d = e.distanceTo(target);
					if (d < minimumDistance) {
						minimumDistance = d;
						closest = e;
					}
				}
				timer--;
				if (closest != null) {
					target.face(closest);
					target.setRotation(target.getRotation());
					if (timer < 0
							&& (closest.distanceTo(target) < getFireRange())
							&& fire) {
						fireBullet();
						bulletsFired++;
						SoundManager.forClass(Defend.class).play(getSound());
						timer = getFireDelay();
					}
					if (bulletsFired >= 1) {
						fire = false;
						bulletsFired = 0;
					}

				}
				if (!fire) {
					fireCoolDown--;
					if (fireCoolDown < 0) {
						fireCoolDown = getFireCoolDown();
						fire = true;
					}
				}

			}

		});
	}

	public abstract double getFireRange();

	public abstract int getFireDelay();

	public abstract int getFireCoolDown();
	
	public abstract int getFireCost();

	public abstract double getBulletSpeed();

	public abstract Bullet createBullet();
	
	public abstract int getTurretCost();

	public abstract String getSound();
	
	
	public double getCurrentHealth(){
		return currentDurablity;
	}
	
	public void fireBullet() {
		fireBullet(0,0);
	}
	public void fireBullet(double angleDifference, double speedModifier) {
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		final ConstantMovementController cmc = ConstantMovementController.createPolar(getBulletSpeed()+speedModifier, getRotation()+ angleDifference);
		DelayListener dl = new DelayListener(5) {

			@Override
			public void invoke(GObject target, Context context) {
				cmc.setDamping(1.1);
				b.addController(cmc);

			}
		};
		b.addListener(dl);
		snapAnchor(b);
		b.moveAtAngle(getWidth() / 2 + 20, getRotation()+ angleDifference);
		this.addSibling(b);
		takeDurablity();

	}

	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
	
	public void takeDurablity() {
		this.currentDurablity -= getFireCost();
		hb.setHealthPercentage(this.currentDurablity / maxDurablity);
		if (currentDurablity <= 0) {
			this.removeSelf();
			Bank.addMoney(getTurretCost() / 2);
		}
	}
	
}
