package Enemies;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;

import Mechanics.HealthBar;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;

public abstract class Enemy extends GSprite {
	private double maxHealth;
	private double currentHealth;
	private HealthBar hb = new HealthBar();

	public Enemy(Image image, double maxHealth) {
		super(image);
		this.maxHealth = maxHealth;
		currentHealth = this.maxHealth;

		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);

		int[] x = new int[] { 11, 37, 62, 87, 112, 138, 163, 189, 214, 239,
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
		int[] y = new int[] { 104, 106, 105, 104, 106, 106, 104, 104, 105, 106,
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
		Polygon p = new Polygon(x, y, 196);
		PolygonController pc = new PolygonController(p);
		pc.goToStart(this);
		pc.setRotateToFollow(true);
		addController(pc);
		addListener(new BoundaryRemovalListener());

	}

	public abstract double getSlowness();

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
		hb.setHealthPercentage(this.currentHealth / maxHealth);
		if (currentHealth <= 0) {
			this.removeSelf();
		}
	}

	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		GObject.antialias(g);
		goodImageTransforms(g);
	}

}
