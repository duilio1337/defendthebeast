package Levels;

import java.awt.Color;

import jgame.GSprite;
import jgame.ImageCache;
import areas.PlayArea;

public class PlayAreaOne extends PlayArea{
	public PlayAreaOne() {
		super("Levels/Level1.png");
		setSize(1280, 720);
		setBackgroundColor(Color.PINK);
		GSprite g = new GSprite(ImageCache.getImage("Levels/Level1.png"));
		setBackgroundSprite(g);
		
		// 1=Enemy1 2=Enemy2.... 101=Boss1 102=Boss2
		
		wave1 = new int[] {
			1,1,1,1,1
		};
		
		wave2 = new int[] {
			2,2,2,2,2
		};
		
		wave3 = new int[] {
			3,3,3,3,3
		};
		
		wave4 = new int[] {
			4,4,4,4,4
		};
		
		wave5 = new int[] {
			5,5,5,5,5,101
		};
		
		startWave(wave1);
		nextWave = 1;
	}
}
