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
	private boolean placed = false;
	private int timer = 0;
	private boolean fire = true;
	private int fireCoolDown = getFireCoolDown();
	private int bulletsFired = 0;
	
	public Boss(Image image, double health) {
		super(image, health);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
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
