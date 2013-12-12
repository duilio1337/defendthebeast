package dtb;

import java.awt.Color;
import java.awt.Polygon;
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
import jgame.listener.FrameListener;
import jgame.listener.LocalClickListener;
import Mechanics.Bank;
import Turrets.RangeRing;
import Turrets.Turret;
import Turrets.Turret1;
import Turrets.Turret2;
import Turrets.Turret3;
import Turrets.Turret4;
import Turrets.Turret5;
import areas.MenuArea;
import areas.PlayArea;

public class DefendGameView extends GContainer {
	private PlayArea pa = new PlayArea();
	private boolean settingTurret = false;
	private Bank bank;
	private static GMessage gm = new GMessage();

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

		bank = new Bank(500);

		GSprite bankTile = createSprite();
		addAt(bankTile, 1200, 40);

		FrameListener fl = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				gm.setText(bank.toString());
			}
		};
		addListener(fl);
		
	}

	public static GSprite createSprite() {
		BufferedImage img = ImageCache.forClass(Defend.class).get(
				"Tiles/selectnew.png");
		GSprite gs = new GSprite(img);

		Rectangle nineSliceCenter = new Rectangle(15, 15, 6, 6);
		gs.setNineSliceCenter(nineSliceCenter);
		gs.setSize(100, 55);

		gm.setAlignmentX(0.5);
		gm.setAlignmentY(0.5);
		gm.setFontSize(28);
		gm.setColor(Color.WHITE);
		gs.addAtCenter(gm);
		return gs;
	}

	public void initializeTurret(final Turret t) {
		if (settingTurret) {
			return;
		}
		settingTurret = true;
		final RangeRing rr = new RangeRing(t.getFireRange());
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		this.pa.addAtCenter(t);
		this.pa.addAtCenter(rr);
		rr.addController(mlc);
		
		final int[] x = new int[] { 11, 37, 62, 87, 112, 138, 163, 189, 214, 239,
				264, 290, 316, 325, 324, 322, 320, 318, 317, 317, 319, 322,
				322, 323, 323, 321, 318, 343, 368, 393, 418, 443, 468, 494,
				519, 544, 570, 596, 621, 646, 671, 672, 666, 668, 672, 673,
				671, 670, 671, 671, 672, 675, 682, 677, 681, 677, 677, 700,
				725, 751, 777, 803, 830, 856, 882, 908, 934, 959, 975, 970,
				969, 967, 966, 968, 967, 942, 917, 892, 867, 848, 847, 849,
				851, 852, 851, 849, 849, 850, 853, 854, 854, 852, 852, 851,
				847, 853, 880, 905, 932, 957, 982, 1008, 1034, 1061, 1087,
				1112, 1137, 1145, 1145, 1142, 1140, 1140, 1139, 1141, 1143,
				1142, 1137, 1136, 1117, 1092, 1066, 1040, 1015, 990, 965, 939,
				914, 888, 863, 838, 812, 786, 761, 736, 711, 686, 661, 636,
				611, 585, 560, 535, 510, 485, 459, 434, 409, 383, 358, 333,
				308, 283, 258, 233, 207, 182, 156, 131, 106, 84, 85, 85, 84,
				81, 80, 82, 85, 85, 86, 111, 137, 163, 188, 214, 240, 265, 291,
				317, 342, 367, 393, 418, 445, 471, 497, 509, 505, 504, 504,
				503, 503, 503, 503, 503, 503, 503 };
		final int[] y = new int[] { 104, 106, 105, 104, 106, 106, 104, 104, 105, 106,
				104, 104, 104, 128, 153, 178, 203, 228, 254, 280, 305, 330,
				356, 381, 407, 432, 457, 458, 459, 460, 461, 462, 463, 462,
				461, 459, 458, 458, 455, 454, 455, 430, 405, 380, 355, 330,
				305, 280, 255, 229, 204, 178, 153, 128, 103, 78, 52, 42, 40,
				43, 43, 43, 43, 43, 43, 43, 43, 45, 65, 90, 115, 140, 165, 190,
				215, 221, 220, 218, 216, 233, 258, 283, 308, 333, 358, 383,
				409, 434, 459, 484, 510, 535, 561, 586, 611, 636, 636, 638,
				638, 637, 635, 633, 632, 632, 632, 633, 635, 611, 585, 560,
				535, 509, 484, 459, 434, 409, 384, 359, 342, 346, 346, 346,
				345, 344, 343, 343, 341, 342, 343, 344, 344, 343, 341, 342,
				341, 340, 338, 337, 336, 336, 337, 338, 340, 341, 341, 343,
				347, 345, 342, 338, 336, 334, 332, 336, 337, 340, 340, 337,
				336, 349, 374, 400, 425, 451, 476, 501, 526, 552, 577, 572,
				572, 575, 576, 576, 578, 580, 579, 576, 575, 573, 573, 576,
				576, 575, 572, 594, 619, 644, 670, 695, 720, 745, 770, 795,
				820, 845 };
		final Polygon path = new Polygon(x, y, 196);
		
		final LocalClickListener lcl = new LocalClickListener() {

			@Override
			public void invoke(GObject target, Context context) {
				for(int i = 0; path.npoints > i; i++) {
					if (target.distanceTo(x[i], y[i]) < 30) {
						return;
					}
				}
				
				for (GObject child : pa.getObjects()) {
					if (child != t && child instanceof Turret && child.hitTest(t)) {
						return;
					}
				}
				target.removeController(mlc);
				target.removeListener(this);
				rr.removeController(mlc);
				rr.removeSelf();
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
		gm.setColor(Color.WHITE);
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

	public boolean turretAfford(int turNum) {
		boolean bool = false;
		switch (turNum) {
		case 1:
			if (Turret1.getCost() <= Bank.getMoney()) {
				Bank.takeMoney(Turret1.getCost());
				bool = true;
			}
			break;

		case 2:
			if (Turret2.getCost() <= Bank.getMoney()) {
				Bank.takeMoney(Turret2.getCost());
				bool = true;
			}
			break;

		case 3:
			if (Turret3.getCost() <= Bank.getMoney()) {
				Bank.takeMoney(Turret3.getCost());
				bool = true;
			}
			break;

		case 4:
			if (Turret4.getCost() <= Bank.getMoney()) {
				Bank.takeMoney(Turret4.getCost());
				bool = true;
			}
			break;

		case 5:
			if (Turret5.getCost() <= Bank.getMoney()) {
				Bank.takeMoney(Turret5.getCost());
				bool = true;
			}
			break;

		default:
			bool = false;
			break;
		}
		return bool;
	}
	
	public void newHUDMessage(String text, int time, int loc) {
		final GMessage messageHUD = new GMessage();
	
		messageHUD.setAlignmentX(0.5);
		messageHUD.setAlignmentY(0.5);
		messageHUD.setFontSize(28);
		messageHUD.setColor(Color.WHITE);
		messageHUD.setAlpha(1);
		messageHUD.setText(text);
		switch(loc){
		case 1:
			addAt(messageHUD, 1280/2, 100);
			break;
		case 2:
			addAtCenter(messageHUD);
			break;
		case 3:
			addAt(messageHUD, 1280/2, 600);
			break;
		}
		
		DelayListener dl = new DelayListener(time) {
			@Override
			public void invoke(GObject target, Context context) {
				messageHUD.removeSelf();
			}
		};
		addListener(dl);
	}
}
