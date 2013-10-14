package Enemies;

import java.awt.Image;
import java.awt.Polygon;

import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;

public abstract class Enemy extends GSprite {
	public Enemy(Image image) {
		super(image);
		int[] x = new int[] { 1, 26, 52, 78, 104, 130, 156, 182, 208, 232, 231,
				230, 230, 254, 279, 305, 332, 358, 384, 411, 437, 463, 489,
				507, 513, 513, 513, 514, 515, 519, 520, 523, 523, 526, 525,
				523, 523, 535, 560, 585, 610, 636, 662, 688, 716, 742, 770,
				796, 821, 847, 873, 899, 925, 948, 962, 968, 971, 971, 974,
				974, 975, 976, 981, 1002, 1022, 1046, 1072, 1098, 1124, 1149,
				1176, 1202, 1228, 1254, 1280 };
		int[] y = new int[] { 434, 432, 432, 433, 433, 433, 433, 433, 433, 441,
				466, 491, 517, 528, 530, 530, 530, 530, 530, 530, 530, 530,
				530, 512, 487, 461, 435, 410, 385, 360, 335, 310, 284, 259,
				234, 209, 183, 161, 159, 155, 151, 151, 151, 151, 151, 151,
				151, 151, 150, 150, 150, 150, 150, 160, 183, 208, 234, 260,
				286, 312, 339, 364, 390, 405, 421, 429, 426, 426, 426, 427,
				427, 427, 427, 430, 430 };
		Polygon p = new Polygon(x, y, 75);
		PolygonController pc = new PolygonController(p);
		pc.goToStart(this);
		pc.setRotateToFollow(false);
		addController(pc);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}

}
