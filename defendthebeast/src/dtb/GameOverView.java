package dtb;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;
import dtb.Defend.Views;

public class GameOverView extends GContainer {
	public GameOverView() {
		setSize(1280, 720);

		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"Other/MenuScreen.png");
		GSprite g = new GSprite(bg);
		setBackgroundSprite(g);

		GMessage m = new GMessage("Game Over");
		m.setAnchorTopLeft();
		m.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		m.setFontSize(100);

		GMessage m2 = new GMessage("Try Harder Next Time ._.");
		m2.setAnchorTopLeft();
		m2.setColor(Color.WHITE);
		m2.setFontSize(70);

		GButton b = createButton(0, "Main Menu");
		addAtCenter(b);
		b.addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.MENU);
			}
		});

		addAt(m, 1280 / 3.5, 200);
		addAt(m2, 1280 / 4.75, 600);
	}

	private GButton createButton(final int buttonIndex, String buttonText) {

		final GButton btn = new GButton();
		btn.setStateSprite(ButtonState.NONE,
				createButtonSprite("Tiles/menubarnew.png"));
		btn.setStateSprite(ButtonState.HOVERED,
				createButtonSprite("Tiles/selectnew.png"));
		btn.setStateSprite(ButtonState.PRESSED,
				createButtonSprite("Tiles/pressedbarnew.png"));
		btn.setSize(250, 55);
		GMessage gm = new GMessage(buttonText);

		gm.setSize(btn.getWidth(), btn.getHeight());
		gm.setAlignmentX(0.5);
		gm.setAlignmentY(0.5);
		gm.setFontSize(28);
		gm.setColor(Color.WHITE);
		btn.addAtCenter(gm);

		return btn;
	}

	public static GSprite createButtonSprite(String fn) {
		BufferedImage img = ImageCache.forClass(Defend.class).get(fn);
		GSprite gs = new GSprite(img);

		Rectangle nineSliceCenter = new Rectangle(15, 15, 6, 6);
		gs.setNineSliceCenter(nineSliceCenter);
		return gs;
	}
}
