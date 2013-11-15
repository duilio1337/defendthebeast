package Turrets;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.listener.DelayListener;
import jgame.listener.FrameListener;
import Enemies.Enemy;
import Mechanics.HealthBar;
import bullets.Bullet;

public abstract class Turret extends GSprite {
	private boolean placed = false;
	private int timer = 0;
	private boolean fire = true;
	private int fireCoolDown = getFireCoolDown();
	private int bulletsFired = 0;
	private double maxHealth;
	private double currentHealth;
	private HealthBar hb = new HealthBar();

	public Turret(Image image, double maxHealth) {
		super(image);
		
		this.maxHealth = maxHealth;
		currentHealth = this.maxHealth;
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

	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
}
