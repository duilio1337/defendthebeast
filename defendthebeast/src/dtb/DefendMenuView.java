package dtb;

import dtb.Defend;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class DefendMenuView extends GContainer {
	
	public DefendMenuView () {
		
		super(new GSprite(ImageCache.forClass(Defend.class).get("download.png")));
		
	}

}
