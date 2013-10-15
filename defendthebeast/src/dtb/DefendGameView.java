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
		ma.setAnchorTopLeft();
		ma.setLocation(1280, 720);
		add(ma);
		
		
	}

}
