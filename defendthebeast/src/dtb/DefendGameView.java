package dtb;

import jgame.GContainer;
import areas.PlayArea;

public class DefendGameView extends GContainer {
	private PlayArea pa = new PlayArea();
	public DefendGameView () {

		setSize(1280, 720);
		pa.setAnchorTopLeft();
		add(pa);
		
		
	}

}
