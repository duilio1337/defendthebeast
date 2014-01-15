package Enemies;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;

import dtb.Defend;
import dtb.Defend.Views;
import Mechanics.Bank;
import Mechanics.HealthBar;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;
import Mechanics.Bank;
import Mechanics.HealthBar;
import dtb.Defend.Views;

public abstract class Enemy extends GSprite {
	private double maxHealth;
	private double currentHealth;
	private int killPoints;
	private HealthBar hb = new HealthBar();
	final PolygonController pc;
	private int[] x;
	private int[] y;

	public Enemy(Image image, double maxHealth, int killPoints) {
		super(image);
		this.maxHealth = maxHealth;
		currentHealth = this.maxHealth;
		this.killPoints = killPoints;

		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);

		x = DefendGameView.getX();
		y = LevelOne.getY();
		
		Polygon p = new Polygon(x, y, x.length);
		pc = new PolygonController(p);
		pc.goToStart(this);
		pc.setRotateToFollow(true);
		pc.setMaxSpeed(getSlowness());
		addController(pc);
		addListener(new BoundaryRemovalListener() {
			@Override
			public void invoke(GObject target, Context context) {
				context.setCurrentGameView(Views.GAME_OVER);
				target.removeSelf();
			}
		});
	}

	public abstract double getSlowness();

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
		hb.setHealthPercentage(this.currentHealth / maxHealth);
		if (currentHealth <= 0) {
			Bank.addMoney(killPoints);
			this.removeSelf();
		}
	}

	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		GObject.antialias(g);
		goodImageTransforms(g);
	}

}
