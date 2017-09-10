package nitroGame.Visuals;

import java.awt.Graphics;

import nitroGame.Core.Interfaces.Visual;

public class Level implements Visual {

	private CompositeVisual compVisual;

	@Override
	public void tick() {
		compVisual.tick();

	}

	@Override
	public void render(Graphics graphics) {
		compVisual.render(graphics);
	}

	@Override
	public String key() {
		return this.key();
	}
}