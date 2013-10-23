package areas;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.TimerListener;
import Enemies.Boss1;
import Enemies.Enemy;
import Enemies.Enemy1;
import Enemies.Enemy2;
import Enemies.Enemy3;
import Enemies.Enemy4;
import Enemies.Enemy5;
import dtb.Defend;

public class PlayArea extends GContainer {
	public PlayArea() {
		setSize(1280, 720);
		setBackgroundColor(Color.PINK);
		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"Level1.png");
		GSprite g = new GSprite(bg);
		setBackgroundSprite(g);

		final TimerListener enemyTimer = new TimerListener(120) {

			@Override
			public void invoke(GObject target, Context context) {
				addRandomEnemy();
			}

		};
		addListener(enemyTimer);
	}

	private void addRandomEnemy() {
		int pick = (int) (Math.random() * 101);
		Enemy e = null;
		if(pick<15){
			e = new Enemy1();
		}else if(pick<30){
			e = new Enemy2();
		}else if(pick<50){
			e = new Enemy3();
		}else if(pick<72){
			e = new Enemy4();
		}else if(pick<98){
			e = new Enemy5();
		}else if(pick<100){
			e = new Boss1();
		}else{
			e = new Enemy1();
		}
		this.add(e);
	}
}
