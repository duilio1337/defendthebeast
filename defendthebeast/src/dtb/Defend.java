package dtb;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;

public class Defend extends Game {

	public DefendGameView l1 = new Level1();
	public DefendGameView l2 = new Level2();
	public DefendGameView l3 = new Level3();

	private static boolean paused = false;
	private static int levelnum = 0;
	private static int levelunlocked = 1;
	private static int carryovermoney = 100;

	public static void main(String[] args) {
		ImageCache.create(Defend.class, "/dtb/rsc/");
		SoundManager.create(Defend.class, "/dtb/rsc/Sounds/");
		Defend d1 = new Defend();
		d1.startGame("Defend the Beast A3.2");
	}

	public Defend() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);
		DefendMenuView dmv = new DefendMenuView();
		GameOverView gov = new GameOverView();
		DefendInstView dig = new DefendInstView();
		DefendPauseView dpv = new DefendPauseView();
		DefendLevelMenu dlm = new DefendLevelMenu();
		GameWinView gwv = new GameWinView();
		DefendCreditsView dcv = new DefendCreditsView();
		root.addView(Views.MENU, dmv);
		root.addView(Views.LEVEL1, l1);
		root.addView(Views.LEVEL2, l2);
		root.addView(Views.LEVEL3, l3);
		root.addView(Views.GAME_OVER, gov);
		root.addView(Views.WIN, gwv);
		root.addView(Views.INSTRUCTIONS, dig);
		root.addView(Views.LEVELMENU, dlm);
		root.addView(Views.PAUSE, dpv);
		root.addView(Views.CREDITS, dcv);

		setTargetFPS(30);
	}

	public enum Views {
		// These are all of the views for this game
		MENU, LEVEL1, LEVEL2, LEVEL3, LEVELMENU, GAME_OVER, INSTRUCTIONS, PAUSE, WIN, CREDITS;
	}

	public static boolean isPaused() {
		return paused;
	}

	public static void setPaused(boolean status) {
		paused = status;
	}

	public static int isLevel() {
		return levelnum;
	}

	public static void setLevel(int level) {
		levelnum = level;
	}

	public static int isLevelUnlocked() {
		return levelunlocked;
	}

	public static void setLevelUnlocked(int level) {
		levelunlocked = level;
	}
	
	public static int getCarriedMoney() {
		return carryovermoney;
	}
	
	public static void setCarriedMoney(int money) {
		carryovermoney = money;
	}
}
