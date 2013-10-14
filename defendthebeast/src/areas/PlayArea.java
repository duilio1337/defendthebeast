package areas;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import dtb.Defend;

public class PlayArea extends GContainer{
	public PlayArea(){
		setSize(1280,720);
		setBackgroundColor(Color.PINK);
		BufferedImage bg = ImageCache.forClass(Defend.class).get("white.jpg");
		GSprite g = new GSprite(bg);
		setBackgroundSprite(g);
	}
}
