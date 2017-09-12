package nitro.game.visuals;

import java.util.Collection;

import nitro.game.graphics.GraphicsWrapper;

public class CompositeVisual implements Visual {

	private String key;
	VisualCollection visuals;

	public CompositeVisual(String key) {
		this.key = key;
		visuals = new VisualCollection();
	}
	
	public void addVisual(Visual visual) {
		visuals.add(visual);
	}
	
	public void removeVisual(Visual visual) {
		visuals.remove(visual.key());
	}
	
	public Visual getVisual(String key) {
		return visuals.get(key);
	}
	
	public Collection<Visual> visuals(){
		return visuals.values();
	}

	@Override
	public void tick() {
		this.visuals.forEach((k, v) -> v.tick());
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		this.visuals.values().stream()
			.sorted((a, b) -> ((Integer) a.zIndex()).compareTo(b.zIndex()))
			.forEach(v -> v.render(graphics));
	}

	@Override
	public String key() {
		return this.key;
	}
}