package Enemies;

import java.awt.Image;

import jgame.listener.BoundaryRemovalListener;


public abstract class Boss extends Enemy{
	
	public Boss(Image image, double health, int killPoints) {
		super(image, health, killPoints);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}
}

