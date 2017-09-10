package nitroGame.Core;

import java.awt.Graphics;
import java.util.Collection;
import java.util.stream.Collectors;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.Visuals.Level;
import nitroGame.Visuals.SelectionVisual;

public class LevelManager implements Visual {
	private static final String LEVEL_MANAGER_KEY = "LEVEL_MANAGER";

	public SelectionVisual levels;

	public void addLevel(Level level) {
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
	public void render(Graphics graphics) {
		levels.render(graphics);
	}
}
