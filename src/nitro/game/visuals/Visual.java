package nitro.game.visuals;

import nitro.game.graphics.GraphicsWrapper;

public interface Visual {
	String key();

	default int zIndex() {
		return 0;
	}

	void tick();

	void render(GraphicsWrapper graphicsWrapper);
}