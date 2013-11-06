package Enemies;

import java.awt.Image;

import jgame.listener.BoundaryRemovalListener;

public abstract class Boss extends Enemy{
	public Boss(Image image, double health) {
		super(image, health);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}
	

}
