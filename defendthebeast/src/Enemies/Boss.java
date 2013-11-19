package Enemies;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.listener.DelayListener;
import jgame.listener.FrameListener;
import Enemies.Enemy;
import bullets.Bullet;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;
import Turrets.Turret;


public abstract class Boss extends Enemy{
	private boolean spawned = false;
	private int timer = 0;
	private boolean fire = true;
	private int fireCoolDown = getFireCoolDown();
	private int bulletsFired = 0;
	
	public Boss(Image image, double health) {
		super(image, health);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
		this.addListener(new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {

				if (!spawned) {
					return;
				}
				List<Turret> turrets = context.getInstancesOfClass(Turret.class);
				double minimumDistance = Integer.MAX_VALUE;
				Turret closest = null;

				for (Turret t : turrets) {
					double d = t.distanceTo(target);
					if (d < minimumDistance) {
						minimumDistance = d;
						closest = t;
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

	public abstract double getBulletSpeed();

	public abstract Bullet createBullet();

	public void fireBullet() {
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		final ConstantMovementController cmc = ConstantMovementController
				.createPolar(getBulletSpeed(), getRotation());
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

	public boolean isSpawned() {
		return spawned;
	}

	public void setSpawned(boolean spawned) {
		this.spawned = spawned;
	}
	

}
