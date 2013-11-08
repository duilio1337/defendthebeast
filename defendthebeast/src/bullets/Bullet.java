package bullets;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;
import Enemies.Enemy;

public class Bullet extends GSprite {

	private double bd;
	private Point initialPosition = new Point();

	public Bullet(Image image, double bulletDamage) {
		super(image);
		bd = bulletDamage;
		addListener(new BoundaryRemovalListener());

		HitTestListener htl = new HitTestListener(Enemy.class) {

			@Override
			public void invoke(GObject target, Context context) {
				List<Enemy> enemies = context.hitTestClass(Enemy.class);
				for (Enemy enemy : enemies) {
					enemy.setCurrentHealth(enemy.getCurrentHealth() - bd);
				}
				target.removeSelf();
			}
		};
		addListener(htl);
	}

	public double getBd() {
		return bd;
	}

	public void setBd(double bd) {
		this.bd = bd;
	}

	public Point getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Point initialPosition) {
		this.initialPosition = initialPosition;
	}
}
