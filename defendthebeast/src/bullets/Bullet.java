package bullets;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;
import Enemies.Enemy;

public class Bullet extends GSprite {
	public Bullet(Image image) {
		super(image);
		addListener(new BoundaryRemovalListener());

		HitTestListener htl = new HitTestListener(Enemy.class) {

			@Override
			public void invoke(GObject target, Context context) {
				target.removeSelf();

			}
		};
		addListener(htl);
	}
}
