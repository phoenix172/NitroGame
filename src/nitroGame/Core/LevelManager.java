package nitroGame.Core;

import java.util.Collection;
import java.util.stream.Collectors;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.Visuals.SelectionVisual;
import nitroGame.graphics.GraphicsWrapper;

public class LevelManager implements Visual {
	public static final String LEVEL_MANAGER_KEY = "LEVEL_MANAGER";

	public SelectionVisual levels;

	public LevelManager() {
		levels = new SelectionVisual(LEVEL_MANAGER_KEY);
	}

	public void add(Level level) {
		levels.add(level);
	}

	public void setCurrentLevel(Level level) {
		levels.setActive(level.key());
	}

	public Collection<Level> levels() {
		return levels.values().stream().map(x -> (Level) x).collect(Collectors.toList());
	}

	@Override
	public String key() {
		return LEVEL_MANAGER_KEY;
	}

	@Override
	public void tick() {
		levels.tick();
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		levels.render(graphics);
	}
}