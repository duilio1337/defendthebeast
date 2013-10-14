package areas;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.TimerListener;
import Enemies.Enemy;
import Enemies.Enemy1;
import dtb.Defend;

public class PlayArea extends GContainer {
	public PlayArea() {
		setSize(1280, 720);
		setBackgroundColor(Color.PINK);
		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"Level1fix.png");
		GSprite g = new GSprite(bg);
		setBackgroundSprite(g);

		final TimerListener enemyTimer = new TimerListener(30) {

			@Override
			public void invoke(GObject target, Context context) {
				addRandomEnemy();
			}

		};
		addListener(enemyTimer);
	}

	private void addRandomEnemy() {
		int pick = (int) (Math.random() * 1);
		Enemy e = null;
		switch (pick) {
		case 0:
			e = new Enemy1();
			break;
		}
		this.add(e);
	}
}
