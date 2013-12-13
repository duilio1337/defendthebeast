package dtb;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

public class Defend extends Game {
	
	public DefendGameView dgv = new DefendGameView();

	public static void main(String[] args) {
		ImageCache.create(Defend.class, "/dtb/rsc/");
		SoundManager.create(Defend.class, "/dtb/rsc/Sounds/");
		Defend d1 = new Defend();
		d1.startGame("Defend the Beast A1.0");
	}

	public Defend() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);
		DefendMenuView dmv = new DefendMenuView();
		GameOverView gov = new GameOverView();
		DefendInstView dig = new DefendInstView();
		root.addView(Views.MENU, dmv);
		root.addView(Views.GAME, dgv);
		root.addView(Views.GAME_OVER, gov);
		root.addView(Views.INSTRUCTIONS, dig);
		
		setTargetFPS(30);
	}
	
	public void newGame(){
		dgv = new DefendGameView();
	}

	/**
	 * These are all of the views for this game
	 * 
	 * @author eettlin
	 * 
	 */
	public enum Views {
		// These are all of the views for this game
		MENU, GAME, GAME_OVER, INSTRUCTIONS, OTHER;
	}
}
