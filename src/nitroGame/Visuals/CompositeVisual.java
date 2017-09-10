package nitroGame.Visuals;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.graphics.GraphicsWrapper;

public class CompositeVisual extends VisualCollection implements Visual {

	private String key;
	public CompositeVisual(String key) {
		this.key = key;
	}
	
	@Override
	public void tick() {
		this.forEach((k, v) -> v.tick());
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		this.forEach((k, v) -> v.render(graphics));
	}

	@Override
	public String key() {
		return this.key;
	}
}