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

public class DefendCreditsView extends GContainer {
	public DefendCreditsView() {
		setSize(1280, 720);
		this.setBackgroundColor(Color.BLACK);

	}

	@Override
	public void viewShown() {
		initDefendCreditsView();
	}

	public void initDefendCreditsView() {
		removeAllChildren();

		BufferedImage bg = ImageCache.forClass(Defend.class).get(
				"Other/MenuScreen.png");
		GSprite g = new GSprite(bg);
		setBackgroundSprite(g);

		GButton mbMM = this.createButton(0, "Main Menu");
		mbMM.setLocation(-100, 100);

		ButtonListener blMM = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.MENU);
			}
		};
		mbMM.addListener(blMM);

		GSprite inst = instPnl();
		add(inst);

		BufferedImage dtb = ImageCache.forClass(Defend.class).get(
				"Other/dtb.png");
		GSprite dtbspr = new GSprite(dtb);
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

	private GSprite instPnl() {
		BufferedImage img = ImageCache.forClass(Defend.class).get(
				"Other/credits.png");
		GSprite gs = new GSprite(img);
		gs.setLocation(2280, 400);

		MovementTween mt = new MovementTween(24, Interpolation.EASE, -1400, 0);
		MovementTween mtb = new MovementTween(6, Interpolation.EASE, 40, 0);
		mt.chain(mtb);
		gs.addController(mt);

		return gs;
	}
}
