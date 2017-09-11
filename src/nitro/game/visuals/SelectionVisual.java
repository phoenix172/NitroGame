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

	private Optional<Visual> currentVisual() {
		if (!visual.isPresent())
			visual = this.values()
				.stream().findFirst();
		return visual;
	}
	
	@Override
	public void tick() {
		if(currentVisual().isPresent())
			currentVisual().get().tick();
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		if (currentVisual().isPresent())
			currentVisual().get().render(graphics);
	}

	@Override
	public String key() {
		return this.key;
	}

	public void addRange(Visual...visuals) {
		Arrays.asList(visuals).forEach(x -> this.add(x));
	}
}