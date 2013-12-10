package Enemies;

import java.awt.Image;
import java.util.List;
import jgame.Context;
import jgame.GObject;
import jgame.controller.ConstantMovementController;
import jgame.listener.DelayListener;
import jgame.listener.FrameListener;
import Enemies.Enemy;
import bullets.Bullet;
import jgame.listener.BoundaryRemovalListener;
import Turrets.Turret;


public abstract class Boss extends Enemy{
	
	public Boss(Image image, double health, int killPoints) {
		super(image, health, killPoints);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
	}
}

