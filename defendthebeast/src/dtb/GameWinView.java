package dtb;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;
import jgame.listener.FrameListener;
import jgame.listener.GlobalKeyListener;
import dtb.Defend.Views;
import dtb.Defend;

public class GameWinView extends GContainer {
	public GameWinView() {
		setSize(1280, 720);

		final GSprite g = new GSprite(
				ImageCache.getImage("Other/win_background.png"));
		g.setAnchorCenter();
		addAtCenter(g);

		GSprite doge = new GSprite(ImageCache.getSequentialImages(
				"Other/doge/doge", 0, 42, ".png"));
		addAtCenter(doge);

		GMessage m = new GMessage("much winner");
		m.setAnchorTopLeft();
		m.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		m.setFontSize(100);

		GMessage m2 = new GMessage("such defend");
		m2.setAnchorCenter();
		m2.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		m2.setFontSize(70);

		GMessage m3 = new GMessage("wows");
		m3.setAnchorCenter();
		m3.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		m3.setFontSize(70);

		GButton b = createButton(0, "Main Menu");
		addAtCenter(b);
		b.addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.MENU);
			}
		});
		
		GButton b2 = createButton(2, "Next Level");
		addAt(b2, 1280/2, 720/2 + 100);
		b2.addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				switch(Defend.isLevelUnlocked()) {
					case 1:
						Defend.setLevel(1);
						context.setCurrentGameView(Views.LEVEL1);
						break;
					case 2:
						Defend.setLevel(2);
						context.setCurrentGameView(Views.LEVEL2);
						break;
					case 3:
						Defend.setLevel(3);
						context.setCurrentGameView(Views.LEVEL3);
						break;
					default :
						System.err.println("ERROR: LEVEL '" + Defend.isLevelUnlocked()
								+ "' NOT DEFINED IN WIN VIEW");
						System.err.println("UPDATE YOUR CLASS WIN FOO!");
				}
			}
		});

		addAt(m, 1280 / 3.5, 600);
		addAt(m2, 1280 / 2, 100);
		addAt(m3, 250, 200);

		FrameListener fl = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				g.setRotation(g.getRotation() + 0.2);
			}
		};
		addListener(fl);
		
		GlobalKeyListener esc = new GlobalKeyListener(KeyEvent.VK_ESCAPE) {

			@Override
			public void invoke(GObject target, Context context) {
				context.setCurrentGameView(Views.MENU);
			}
		};
		
		addListener(esc);
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
