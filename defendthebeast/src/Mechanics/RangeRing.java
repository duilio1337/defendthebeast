package Mechanics;

import java.awt.Color;
import java.awt.Graphics2D;

import jgame.GObject;

public class RangeRing extends GObject {

	public RangeRing(double radius) {
		this.setSize(radius*2, radius*2);
	}

	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		g.fillOval(0, 0, getIntWidth(), getIntHeight());
	}

	@Override
	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		antialias(g);
	}
}
