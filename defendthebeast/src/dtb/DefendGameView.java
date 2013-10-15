package dtb;

import jgame.GContainer;
import areas.MenuArea;
import areas.PlayArea;

public class DefendGameView extends GContainer {
	private PlayArea pa = new PlayArea();
	public DefendGameView () {

		setSize(1280, 720);
		pa.setAnchorTopLeft();
		add(pa);
		
		MenuArea ma = new MenuArea();
		ma.setAnchorCenter();
		ma.setLocation(1280/2, 720-22);
		add(ma);
		
		
	}

}
