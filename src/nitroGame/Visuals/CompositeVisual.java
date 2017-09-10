package nitroGame.Visuals;

import java.awt.Graphics;

import nitroGame.Core.Interfaces.Visual;

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
	public void render(Graphics graphics) {
		this.forEach((k, v) -> v.render(graphics));
	}

	@Override
	public String key() {
		return this.key;
	}
}