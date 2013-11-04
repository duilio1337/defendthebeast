package dtb;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.controller.MouseLocationController;
import jgame.listener.LocalClickListener;
import Turrets.Turret;
import areas.MenuArea;
import areas.PlayArea;

public class DefendGameView extends GContainer {
	private PlayArea pa = new PlayArea();
	private boolean settingTurret = false;

	public DefendGameView() {

		setSize(1280, 720);
		pa.setAnchorTopLeft();
		add(pa);

		MenuArea ma = new MenuArea();
		ma.setAnchorCenter();
		ma.setLocation(1280 / 2, 720 - 22);
		add(ma);
	}

	public void initializeTurret(final Turret t) {
		if (settingTurret) {
			return;
		}
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		final LocalClickListener lcl = new LocalClickListener() {

			@Override
			public void invoke(GObject target, Context context) {
				for (GObject child : pa.getObjects()) {
					if (child != t && child instanceof Turret
							&& child.hitTest(t)) {
						return;
					}
				}
				target.removeController(mlc);
				target.removeListener(this);
				settingTurret = true;
				t.setPlaced(true);
			}

		};
		t.addListener(lcl);

	}
}
