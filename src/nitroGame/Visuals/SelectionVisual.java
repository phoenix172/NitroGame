package nitroGame.Visuals;

import java.awt.Graphics;
import java.util.Optional;

import nitroGame.Core.Interfaces.Visual;

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
	public void render(Graphics graphics) {
		if (visual.isPresent())
			visual.get().render(graphics.create());
	}

	@Override
	public String key() {
		return this.key;
	}
}