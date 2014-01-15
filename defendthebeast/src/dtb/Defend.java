package dtb;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

public class Defend extends Game {
	private static int[] x1 = new int[] { 11, 37, 62, 87, 112, 138, 163, 189,
			214, 239, 264, 290, 316, 325, 324, 322, 320, 318, 317, 317, 319,
			322, 322, 323, 323, 321, 318, 343, 368, 393, 418, 443, 468, 494,
			519, 544, 570, 596, 621, 646, 671, 672, 666, 668, 672, 673, 671,
			670, 671, 671, 672, 675, 682, 677, 681, 677, 677, 700, 725, 751,
			777, 803, 830, 856, 882, 908, 934, 959, 975, 970, 969, 967, 966,
			968, 967, 942, 917, 892, 867, 848, 847, 849, 851, 852, 851, 849,
			849, 850, 853, 854, 854, 852, 852, 851, 847, 853, 880, 905, 932,
			957, 982, 1008, 1034, 1061, 1087, 1112, 1137, 1145, 1145, 1142,
			1140, 1140, 1139, 1141, 1143, 1142, 1137, 1136, 1117, 1092, 1066,
			1040, 1015, 990, 965, 939, 914, 888, 863, 838, 812, 786, 761, 736,
			711, 686, 661, 636, 611, 585, 560, 535, 510, 485, 459, 434, 409,
			383, 358, 333, 308, 283, 258, 233, 207, 182, 156, 131, 106, 84, 85,
			85, 84, 81, 80, 82, 85, 85, 86, 111, 137, 163, 188, 214, 240, 265,
			291, 317, 342, 367, 393, 418, 445, 471, 497, 509, 505, 504, 504,
			503, 503, 503, 503, 503, 503, 503 };

	private static int[] y1 = new int[] { 104, 106, 105, 104, 106, 106, 104,
			104, 105, 106, 104, 104, 104, 128, 153, 178, 203, 228, 254, 280,
			305, 330, 356, 381, 407, 432, 457, 458, 459, 460, 461, 462, 463,
			462, 461, 459, 458, 458, 455, 454, 455, 430, 405, 380, 355, 330,
			305, 280, 255, 229, 204, 178, 153, 128, 103, 78, 52, 42, 40, 43,
			43, 43, 43, 43, 43, 43, 43, 45, 65, 90, 115, 140, 165, 190, 215,
			221, 220, 218, 216, 233, 258, 283, 308, 333, 358, 383, 409, 434,
			459, 484, 510, 535, 561, 586, 611, 636, 636, 638, 638, 637, 635,
			633, 632, 632, 632, 633, 635, 611, 585, 560, 535, 509, 484, 459,
			434, 409, 384, 359, 342, 346, 346, 346, 345, 344, 343, 343, 341,
			342, 343, 344, 344, 343, 341, 342, 341, 340, 338, 337, 336, 336,
			337, 338, 340, 341, 341, 343, 347, 345, 342, 338, 336, 334, 332,
			336, 337, 340, 340, 337, 336, 349, 374, 400, 425, 451, 476, 501,
			526, 552, 577, 572, 572, 575, 576, 576, 578, 580, 579, 576, 575,
			573, 573, 576, 576, 575, 572, 594, 619, 644, 670, 695, 720, 745,
			770, 795, 820, 845 };

	private static int[] x2 = new int[] { 491, 496, 498, 494, 492, 492, 491,
			488, 488, 488, 487, 484, 480, 480, 486, 486, 483, 483, 485, 485,
			484, 481, 465, 443, 419, 393, 366, 341, 316, 294, 280, 275, 271,
			268, 264, 261, 256, 249, 245, 245, 257, 277, 299, 322, 350, 375,
			402, 432, 459, 485, 513, 542, 575, 603, 632, 659, 685, 712, 742,
			774, 801, 827, 855, 881, 910, 936, 964, 990, 1016, 1045, 1072,
			1099, 1124, 1149, 1156, 1162, 1163, 1162, 1151, 1136, 1112, 1086,
			1060, 1028, 1001, 975, 949, 919, 892, 867, 858, 863, 866, 867, 867,
			865, 862, 858, 858, 858, 858, 858, 858, 858, 859, 863, 879, 906,
			932, 957, 981, 1006, 1031, 1057, 1084, 1110, 1136, 1161, 1186,
			1211, 1236, 1241, 1213, 1176, 1099, 996, 859, 712, 551, 370, 184,
			-2, -114, -114, -64, 24, 162, 358, 556, 782, 984, 1188, 1394, 1590,
			1775, 1805, 1805, 1805, 1805, 1782, 1752, 1724, 1688, 1656, 1626,
			1589, 1560, 1530, 1503, 1470, 1441, 1405, 1375, 1342, 1309, 1273,
			1245, 1230, 1211 };
	private static int[] y2 = new int[] { 1, 28, 53, 78, 103, 129, 154, 180,
			206, 233, 261, 288, 313, 339, 364, 391, 416, 442, 468, 495, 520,
			545, 565, 579, 587, 587, 586, 578, 567, 546, 524, 499, 474, 449,
			423, 397, 372, 345, 319, 293, 270, 254, 241, 228, 223, 220, 218,
			218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218, 218,
			218, 218, 218, 218, 218, 218, 218, 216, 209, 209, 209, 209, 207,
			201, 175, 150, 125, 97, 72, 51, 39, 36, 36, 36, 36, 36, 36, 36, 36,
			40, 64, 89, 116, 148, 174, 199, 229, 259, 287, 313, 342, 370, 396,
			424, 450, 475, 497, 506, 509, 514, 522, 526, 530, 534, 536, 536,
			533, 526, 520, 518, 527, 553, 578, 581, 581, 581, 581, 578, 553,
			533, 509, 484, 454, 418, 403, 403, 403, 403, 403, 403, 398, 398,
			396, 396, 396, 400, 426, 458, 484, 496, 507, 513, 518, 524, 529,
			534, 541, 558, 571, 583, 591, 598, 608, 621, 636, 649, 668, 690,
			707 };

	public DefendGameView dgv = new DefendGameView("Levels/Level1.png",
			getX1(), y1);
	public DefendGameView dgv2 = new DefendGameView("Levels/Level2.png",
			getX2(), getY2());
	private static boolean paused = false;
	private static boolean level1 = false;
	private static boolean level2 = false;

	public static int[] getY1() {
		return y1;
	}

	public void setY1(int[] y1) {
		this.y1 = y1;
	}

	public static int[] getX1() {
		return x1;
	}

	public void setX1(int[] x1) {
		this.x1 = x1;
	}

	public static boolean isLevelOne() {
		return level1;
	}

	public static void setLevelOne(boolean status) {
		level1 = status;
	}

	public static boolean isLevelTwo() {
		return level2;
	}

	public static void setLevelTwo(boolean status) {
		level2 = status;
	}

	public static void main(String[] args) {
		ImageCache.create(Defend.class, "/dtb/rsc/");
		SoundManager.create(Defend.class, "/dtb/rsc/Sounds/");
		Defend d1 = new Defend();
		d1.startGame("Defend the Beast A2.0");
	}

	public Defend() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);
		DefendMenuView dmv = new DefendMenuView();
		GameOverView gov = new GameOverView();
		DefendInstView dig = new DefendInstView();
		DefendPauseView dpv = new DefendPauseView();
		DefendLevelMenu dlm = new DefendLevelMenu();
		root.addView(Views.MENU, dmv);
		root.addView(Views.GAME, dgv);
		root.addView(Views.GAME2, dgv2);
		root.addView(Views.GAME_OVER, gov);
		root.addView(Views.INSTRUCTIONS, dig);
		root.addView(Views.LEVELMENU, dlm);
		root.addView(Views.PAUSE, dpv);

		setTargetFPS(30);
	}

	public enum Views {
		// These are all of the views for this game
		MENU, GAME, LEVELMENU, GAME_OVER, INSTRUCTIONS, PAUSE, GAME2;
	}

	public static boolean isPaused() {
		return paused;
	}

	public static void setPaused(boolean status) {
		paused = status;
	}

	public static int[] getX2() {
		return x2;
	}

	public void setX2(int[] x2) {
		this.x2 = x2;
	}

	public static int[] getY2() {
		return y2;
	}

	public void setY2(int[] y2) {
		this.y2 = y2;
	}
}
