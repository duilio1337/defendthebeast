package dtb;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class DefendGameView extends GContainer {
	
	public DefendGameView () {
		
		super(new GSprite(ImageCache.forClass(Defend.class).get("Level1fix.png")));
		
		setSize(1280, 720);
		
		
	}

}
