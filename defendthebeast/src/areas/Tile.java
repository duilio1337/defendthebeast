package areas;

import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;
import dtb.DefendGameView;
import Turrets.Turret;

public class Tile extends GButton {
	TurretRecipe tr;

	public Tile(TurretRecipe recipe, Image image) {
		this.tr = recipe;

		setSize(66, 66);

		GSprite sNone = ImageCache.getSprite("Tiles/menubarnew.png");
		GSprite sHover = ImageCache.getSprite("Tiles/selectnew.png");
		GSprite sPressed = ImageCache.getSprite("Tiles/selectnew.png");

		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);

		GSprite sIcon = new GSprite(image);

		sIcon.setScale(0.7);
		addAtCenter(sIcon);

		addListener(new ButtonListener() {

			@Override
			public void mouseClicked(Context context) {
				Turret turret = tr.createTurret();

				getFirstAncestorOf(DefendGameView.class).initializeTurret(
						turret);
			}

		});

	}
}
