package nitroGame.Core;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.Visuals.CompositeVisual;
import nitroGame.graphics.GraphicsWrapper;

public abstract class Level implements Visual {

	private CompositeVisual compVisual;

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
		compVisual.render(graphicsWrapper);
	}

	@Override
	public String key() {
		return this.key;
	}
}