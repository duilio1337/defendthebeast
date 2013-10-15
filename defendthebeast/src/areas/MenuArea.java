package areas;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import dtb.Defend;

public class MenuArea extends GContainer {
	public MenuArea() {
		setSize(182, 22);
		this.setBackgroundColor(Color.PINK);

		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"menubar_bg.png");

		GSprite bs = new GSprite(bg);
		setBackgroundSprite(bs);
	}
}
