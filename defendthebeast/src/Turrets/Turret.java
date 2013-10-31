package Turrets;

import java.awt.Image;
import java.util.List;

import bullets.Bullet;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.FrameListener;
import Enemies.Enemy;

public abstract class Turret extends GSprite {
	private boolean placed = false;
	private int fireTimer = 0;
	public Turret(Image image) {
		super(image);
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


			}

		}); 
	}

		public boolean isPlaced() {
			return placed;
		}

		public void setPlaced(boolean placed) {
			this.placed = placed;
		}
		public abstract double getFireRange();

        public abstract int getFireDelay();

        public abstract int getFireCoolDown();

        public abstract double getBulletSpeed();

        public abstract Bullet createBullet();
	}

