package areas;

import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;
import Turrets.Turret;
import dtb.Defend;
import dtb.DefendGameView;

public class Tile extends GButton {
	TurretRecipe tr;
	
	GSprite infocard1 = new GSprite(ImageCache.forClass(Defend.class).get("Other/info-card1.png"));
	GSprite infocard2 = new GSprite(ImageCache.forClass(Defend.class).get("Other/info-card2.png"));
	GSprite infocard3 = new GSprite(ImageCache.forClass(Defend.class).get("Other/info-card3.png"));
	GSprite infocard4 = new GSprite(ImageCache.forClass(Defend.class).get("Other/info-card4.png"));
	GSprite infocard5 = new GSprite(ImageCache.forClass(Defend.class).get("Other/info-card5.png"));

	public Tile(TurretRecipe recipe, Image image, final int turNum) {
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
				
				if(getFirstAncestorOf(DefendGameView.class).turretAfford(turNum)) {
					Turret turret = tr.createTurret();
					getFirstAncestorOf(DefendGameView.class).initializeTurret(turret);
				}else{
					getFirstAncestorOf(DefendGameView.class).newHUDMessage("Insufficient funds", 60, 3);
				}
			}

		});
		
		addListener(new ButtonListener() {
			@Override
			public void mouseOver(Context context) {
				switch(turNum) {
				case 1:
					getFirstAncestorOf(DefendGameView.class).addAt(infocard1, getX()+30, 580);
					break;
				case 2:
					getFirstAncestorOf(DefendGameView.class).addAt(infocard2, getX()+30, 580);
					break;
				case 3:
					getFirstAncestorOf(DefendGameView.class).addAt(infocard3, getX()+30, 580);
					break;
				case 4:
					getFirstAncestorOf(DefendGameView.class).addAt(infocard4, getX()+30, 580);
					break;
				case 5:
					getFirstAncestorOf(DefendGameView.class).addAt(infocard5, getX()+30, 580);
					break;
				}
				
			}
		});
		
		addListener(new ButtonListener() {
			@Override
			public void mouseOut(Context context) {
				switch(turNum) {
				case 1:
					remove(infocard1);
					break;
				case 2:
					remove(infocard2);
					break;
				case 3:
					remove(infocard3);
					break;
				case 4:
					remove(infocard4);
					break;
				case 5:
					remove(infocard5);
					break;
				}
			}
		});

	}
}
