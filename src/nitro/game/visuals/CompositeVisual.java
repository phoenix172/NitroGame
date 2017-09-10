package nitro.game.visuals;

import nitro.game.graphics.GraphicsWrapper;

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
		this.values().stream().sorted((a, b) -> ((Integer) a.zIndex()).compareTo(b.zIndex()))
				.forEach(v -> v.render(graphics));
	}

	@Override
	public String key() {
		return this.key;
	}
}