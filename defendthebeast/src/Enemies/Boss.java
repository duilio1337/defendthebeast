package Enemies;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;
import Turrets.Turret;

public abstract class Boss extends Enemy{
	public Boss(Image image, double health) {
		super(image, health);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}
	

}
