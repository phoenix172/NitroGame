package nitro.game.sample;

import nitro.game.core.Level;
import nitro.game.graphics.StaticBackground;

public class CustomLevel extends Level{

	public CustomLevel(String key) {
		super(key);
		
		addChildren();
	}

	private void addChildren() {
		StaticBackground background = new StaticBackground(resources().get("BACKGROUND"));
		children().add(background);
		children().add(new Cube());
	}
	
}