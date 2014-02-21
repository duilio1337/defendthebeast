package areas;

import java.awt.Color;
import java.awt.Graphics2D;

import jgame.GMessage;
import jgame.GObject;

public class InfoCard extends GObject {

	public InfoCard(int turNum) {
		this.setSize(200, 100);

		GMessage title = new GMessage("Wand of Fire");
		title.setColor(Color.WHITE);
		addAtCenter(title);
	}

	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		g.setColor(new Color(0.4f, 0.4f, 0.4f, 0.7f));
		g.fillRect(0, 0, getIntWidth(), getIntHeight());
	}

	@Override
	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		antialias(g);
	}
}
