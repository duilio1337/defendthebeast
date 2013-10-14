package Enemies;

import java.awt.Image;
import java.awt.Polygon;

import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;

public abstract class Enemy extends GSprite {
	public Enemy(Image image) {
		super(image);
		int[] x = new int[] { 2, 28, 53, 78, 103, 128, 154, 180, 205, 230, 227,
				226, 230, 228, 253, 278, 304, 329, 354, 379, 405, 430, 456,
				481, 506, 505, 504, 508, 505, 505, 503, 503, 502, 502, 501,
				502, 502, 502, 501, 501, 526, 551, 576, 602, 628, 653, 679,
				705, 730, 755, 780, 806, 831, 856, 881, 907, 933, 958, 962,
				961, 967, 966, 966, 965, 966, 967, 966, 966, 968, 966, 992,
				1017, 1042, 1067, 1092, 1118, 1143, 1168, 1194, 1220, 1245,
				1271, 1297, 1322 };
		int[] y = new int[] { 434, 434, 431, 433, 434, 435, 435, 435, 437, 434,
				459, 484, 509, 534, 531, 533, 533, 534, 533, 535, 535, 536,
				536, 534, 533, 508, 483, 458, 433, 407, 382, 356, 331, 305,
				280, 255, 229, 203, 178, 152, 149, 148, 146, 146, 146, 145,
				145, 145, 144, 145, 143, 143, 142, 140, 141, 141, 141, 140,
				165, 190, 215, 240, 266, 291, 316, 341, 366, 392, 417, 442,
				442, 441, 445, 444, 440, 440, 439, 438, 438, 438, 437, 437,
				437, 439 };
		Polygon p = new Polygon(x, y, 84);
		PolygonController pc = new PolygonController(p);
		pc.goToStart(this);
		pc.setRotateToFollow(false);
		addController(pc);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}

}
