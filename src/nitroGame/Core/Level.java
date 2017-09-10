package nitroGame.Core;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.Visuals.CompositeVisual;
import nitroGame.graphics.GraphicsWrapper;
import nitroGame.resources.ImageResource;

public abstract class Level implements Visual {

	private CompositeVisual compVisual;
	private ImageResource background;

	private String key;

	public Level(String key) {
		compVisual = new CompositeVisual(key);
		this.key = key;
	}

	@Override
	public void tick() {
		compVisual.tick();
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		Graphics2D graphics = graphicsWrapper.create();
		Rectangle screenBounds = graphicsWrapper.bounds();
		graphics.drawImage(background.get(), 0, 0, 
				(int) screenBounds.getWidth(), (int) screenBounds.getHeight(), null);
		compVisual.render(graphicsWrapper);
	}

	@Override
	public String key() {
		return this.key;
	}

	public void setBackground(ImageResource resource) {
		this.background = resource;
	}
}