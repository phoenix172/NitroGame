package nitroGame.Core;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.Visuals.CompositeVisual;
import nitroGame.graphics.GraphicsWrapper;

public abstract class Level extends CompositeVisual{

	public Level(String key) {
		super(key);
	}
}