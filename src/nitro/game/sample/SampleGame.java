package nitro.game.sample;

import nitro.game.core.Game;
import nitro.game.core.GameWindow;
import nitro.game.core.Level;
import nitro.game.graphics.StaticBackground;
import nitro.game.resources.ImageResource;
import nitro.game.visuals.Square;

public class SampleGame extends Game{
	public SampleGame() {
		this.title = "Sample Game";
		addReasources();
		addLevels();
	}
	
	private void addReasources() {
		resources().add(new ImageResource("BACKGROUND", "/blue.jpg"));		
	}
	
	private void addLevels() {
		Level pesho = new CustomLevel("pesho");
		StaticBackground background = new StaticBackground(resources().get("BACKGROUND"));

		levels().add(pesho);
		levels().setCurrentLevel(pesho);
		pesho.add(background);
	}
}
