package Enemies;

import java.awt.Image;

import jgame.listener.BoundaryRemovalListener;


public abstract class Boss extends Enemy{

	public Boss(Image image, double health, int killPoints, int[] x, int[] y) {
		super(image, health, killPoints, x, y);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}
}

