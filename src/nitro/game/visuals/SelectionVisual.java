package nitro.game.visuals;

import java.util.Arrays;
import java.util.Optional;

import nitro.game.graphics.GraphicsWrapper;

public class SelectionVisual extends VisualCollection implements Visual {

	private Optional<Visual> visual = Optional.empty();
	private String key;

	public SelectionVisual(String key) {
		this.key = key;
	}

	public void setActive(String key) {
		visual = Optional.of(this.get(key));
	}

	@Override
	public void tick() {
		if (visual.isPresent())
			visual.get().tick();
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		if (visual.isPresent())
			visual.get().render(graphics);
	}

	@Override
	public String key() {
		return this.key;
	}

	public void addRange(Visual...visuals) {
		Arrays.asList(visuals).forEach(x -> this.add(x));
	}
}