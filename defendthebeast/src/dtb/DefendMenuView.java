package dtb;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class DefendMenuView extends GContainer {
	
	public DefendMenuView () {
		
		super(new GSprite(ImageCache.forClass(Defend.class).get("skull_zombie.png")));
		
	}

}
