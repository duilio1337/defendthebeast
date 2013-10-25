package areas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import dtb.Defend;

public class MenuArea extends GContainer {
	public MenuArea() {
	
		//this.setBackgroundColor(Color.BLACK);

		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"Tiles/menubar4x.png");

		GSprite bs = new GSprite(bg);
		setBackgroundSprite(bs);
		
		for (int i = 0; i < 5; i++) {
		    setTile(i);
		}
		
	}
	List<Image> tileImages = ImageCache.forClass(Defend.class).getSequential("Wands/wand", 1, 5, ".png");
	
	private void setTile(int i) {
		Tile tile = new Tile(new IndexedTurretRecipe(i), tileImages.get(i)); 
		tile.setAnchorTopLeft();
		tile.setScale(1.05);
    	addAtCenter(tile);
    	tile.setX(i * 66);
	}
}
