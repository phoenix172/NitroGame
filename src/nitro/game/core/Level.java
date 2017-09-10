package nitro.game.core;

import nitro.game.core.Interfaces.Visual;
import nitro.game.graphics.GraphicsWrapper;
import nitro.game.visuals.CompositeVisual;

public abstract class Level extends CompositeVisual{

	public Level(String key) {
		super(key);
	}
}