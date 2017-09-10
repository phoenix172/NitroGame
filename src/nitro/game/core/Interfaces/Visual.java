package nitro.game.core.Interfaces;

import nitro.game.graphics.GraphicsWrapper;

public interface Visual {
	String key();

	void tick();

	void render(GraphicsWrapper graphicsWrapper);
}