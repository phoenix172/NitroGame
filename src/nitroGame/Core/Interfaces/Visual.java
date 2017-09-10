package nitroGame.Core.Interfaces;

import nitroGame.graphics.GraphicsWrapper;

public interface Visual {
	String key();

	void tick();

	void render(GraphicsWrapper graphics);
}