package nitroGame.Core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.Visuals.CompositeVisual;

public class Level implements Visual {

	private CompositeVisual compVisual;

	private String key;
	public Level(String key) {
		compVisual = new CompositeVisual(key);
		this.key=key;
	}
	
	@Override
	public void tick() {
		compVisual.tick();
	}

	@Override
	public void render(Graphics graphics) {
		Graphics2D g2 = ((Graphics2D)graphics);
		Rectangle screenRectangle = g2.getDeviceConfiguration().getBounds();
		g2.setColor(Color.PINK);
		g2.fill(screenRectangle);
		compVisual.render(graphics);
	}

	@Override
	public String key() {
		return this.key;
	}
}