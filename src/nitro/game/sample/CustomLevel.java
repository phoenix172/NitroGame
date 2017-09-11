package nitro.game.sample;

import nitro.game.core.Level;
import nitro.game.graphics.StaticBackground;

public class CustomLevel extends Level{

	public CustomLevel(String key) {
		super(key);
	}

	@Override
	protected void onLoaded() {
		StaticBackground background = new StaticBackground(resources().get("BACKGROUND"));
		addChild(background);
		children().add(new Cube());
	}
}