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
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class DefendInstView extends GContainer {
	public DefendInstView() {
		setSize(1280, 720);
        this.setBackgroundColor(Color.BLACK);
        this.setBackgroundSprite(ImageCache.getSprite("other/MenuScreen.png"));
		System.out.println("STOP PRESSING MY BUTTONS");
		
		GButton mbMM = this.createButton(0, "Play");
        mbMM.setLocation(100, 200);
        
        ButtonListener blMM = new ButtonListener() {
      	  @Override
      	  public void mouseClicked(Context context) {
      		  super.mouseClicked(context);
      		  context.setCurrentGameView(Views.MENU);
      	  }
       };
       mbMM.addListener(blMM);
}


private GButton createButton(final int buttonIndex, String buttonText) {
    
    final GButton btn = new GButton();
    btn.setStateSprite(ButtonState.NONE, createButtonSprite("Tiles/menubarnew.png"));
    btn.setStateSprite(ButtonState.HOVERED, createButtonSprite("Tiles/selectnew.png"));
    btn.setStateSprite(ButtonState.PRESSED, createButtonSprite("Tiles/pressedbarnew.png"));
    btn.setSize(250, 55);
    GMessage gm = new GMessage(buttonText);
    
    gm.setSize(btn.getWidth(), btn.getHeight());
    gm.setAlignmentX(0.5);
    gm.setAlignmentY(0.5);
    gm.setFontSize(28);
    gm.setColor(Color.BLACK);
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
