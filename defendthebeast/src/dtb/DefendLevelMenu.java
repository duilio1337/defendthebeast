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
import jgame.controller.Interpolation;
import jgame.controller.MovementTween;
import jgame.listener.ButtonListener;
import jgame.listener.DelayListener;
import jgame.listener.GlobalKeyListener;
import dtb.Defend.Views;

public class DefendLevelMenu extends GContainer {

	public DefendLevelMenu() {
		setSize(1280, 720);
	}

	@Override
	public void viewShown() {
		initDefendLevelView();
	}

	public void initDefendLevelView() {
		removeAllChildren();

		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"Other/MenuScreen.png");
		GSprite g = new GSprite(bg);
		setBackgroundSprite(g);

		GButton level1 = this.createButton(0, "Level 1");
		level1.setLocation(-100, 100);
		ButtonListener bll1 = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				Defend.setLevel(1);
				context.setCurrentGameView(Views.LEVEL1);
			}
		};
		level1.addListener(bll1);

		GButton level2 = this.createButton(1, "Level 2");
		level2.setLocation(-100, 100);
		ButtonListener bll2 = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				if (Defend.isLevelUnlocked() >= 2) {
					Defend.setLevel(2);
					context.setCurrentGameView(Views.LEVEL2);
				}
			}
		};
		if(Defend.isLevelUnlocked() < 2)
			level2.setAlpha(0.5);
		
		level2.addListener(bll2);

		GButton level3 = this.createButton(2, "Level 3");
		level3.setLocation(-100, 100);
		ButtonListener bll3 = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				if (Defend.isLevelUnlocked() >= 3) {
					Defend.setLevel(3);
					context.setCurrentGameView(Views.LEVEL3);
				}
			}
		};
		if(Defend.isLevelUnlocked() < 3)
			level3.setAlpha(0.5);
		
		level3.addListener(bll3);
		
		GSprite dtbspr = new GSprite(ImageCache.getImage("Other/dtb.png"));
		addAt(dtbspr, 1280 / 2, 80);
		
		GlobalKeyListener esc = new GlobalKeyListener(KeyEvent.VK_ESCAPE) {

			@Override
			public void invoke(GObject target, Context context) {
				context.setCurrentGameView(Views.MENU);
			}
		};
		
		addListener(esc);
	}

	private GButton createButton(final int buttonIndex, String buttonText) {

		MovementTween mt = new MovementTween(24, Interpolation.EASE, 400, 0);
		MovementTween mtb = new MovementTween(6, Interpolation.EASE, -40, 0);
		mt.chain(mtb);
		final GButton btn = new GButton();
		btn.addController(mt);
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

		DelayListener dl = new DelayListener(buttonIndex * 5) {

			@Override
			public void invoke(GObject target, Context context) {
				addAt(btn, -100, buttonIndex * 100 + 200);
			}
		};
		addListener(dl);
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
