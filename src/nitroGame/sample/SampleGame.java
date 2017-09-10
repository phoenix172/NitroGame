package nitroGame.sample;

import nitroGame.Core.Game;
import nitroGame.Core.Level;
import nitroGame.Core.GameWindow;
import nitroGame.Visuals.Square;
import nitroGame.resources.ImageResource;

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
		pesho.setBackground(resources().get("BACKGROUND"));
		levels().add(pesho);
		levels().setCurrentLevel(pesho);	
	}
}