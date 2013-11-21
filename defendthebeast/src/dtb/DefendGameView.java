package dtb;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dtb.Defend.Views;
import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.Interpolation;
import jgame.controller.MouseLocationController;
import jgame.controller.MovementTween;
import jgame.listener.ButtonListener;
import jgame.listener.DelayListener;
import jgame.listener.LocalClickListener;
import Mechanics.Bank;
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

		GButton mbMM = this.createButton(0, "Main Menu");
		mbMM.setLocation(-100, 700);

		ButtonListener blMM = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				super.mouseClicked(context);
				context.setCurrentGameView(Views.MENU);
			}
		};
		mbMM.addListener(blMM);
		Bank bank = new Bank(500);
		
		GSprite bankTile = createSprite(bank.toString());
		this.addAt(bankTile, 1240, 40);
	}

	public static GSprite createSprite(String string) {
		BufferedImage img = ImageCache.forClass(Defend.class).get("Tiles/selectnew.png");
		GSprite gs = new GSprite(img);

		Rectangle nineSliceCenter = new Rectangle(15, 15, 6, 6);
		gs.setNineSliceCenter(nineSliceCenter);

		GMessage gm = new GMessage(string);

		gm.setSize(gs.getWidth(), gs.getHeight());
		gm.setAlignmentX(0.5);
		gm.setAlignmentY(0.5);
		gm.setFontSize(28);
		gm.setColor(Color.BLACK);
		gs.addAtCenter(gm);
		return gs;
	}

	public void initializeTurret(final Turret t) {
		if (settingTurret) {
			return;
		}
		settingTurret = true;
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		this.pa.addAtCenter(t);
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
				settingTurret = false;
				t.setPlaced(true);
			}

		};
		t.addListener(lcl);

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
		gm.setColor(Color.BLACK);
		btn.addAtCenter(gm);

		DelayListener dl = new DelayListener(buttonIndex * 10) {

			@Override
			public void invoke(GObject target, Context context) {
				addAt(btn, -100, 675);
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
