package nitro.game.core;

import java.util.Collection;
import java.util.stream.Collectors;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.visuals.SelectionVisual;
import nitro.game.visuals.Visual;

public class LevelManager extends VisualObject {
	public static final String LEVEL_MANAGER_KEY = "LEVEL_MANAGER";

	public SelectionVisual levels;

	public LevelManager() {
		setKey(LEVEL_MANAGER_KEY);
		levels = new SelectionVisual(LEVEL_MANAGER_KEY);
	}

	public void addLevel(Level level) {
		levels.add(level);
		onLoaded();
	}

	public void setCurrentLevel(Level level) {
		levels.setActive(level.key());
	}

	public Collection<Level> levels() {
		return levels.values().stream().map(x -> (Level) x).collect(Collectors.toList());
	}

	public SelectionVisual getLevels() {
		return this.levels;
	}

//	@Override
//	public String key() {
//		return LEVEL_MANAGER_KEY;
//	}
//
//	@Override
//	public void tick() {
//		levels.tick();
//	}
//
//	@Override
//	public void render(GraphicsWrapper graphics) {
//		levels.render(graphics);
//	}
}