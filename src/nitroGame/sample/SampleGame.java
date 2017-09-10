package nitroGame.sample;

import nitroGame.Core.Game;
import nitroGame.Core.Level;
import nitroGame.Core.Window;
import nitroGame.Visuals.Square;
import nitroGame.resources.ImageResource;

public class SampleGame extends Game{
	public static void main(String[] args) {
		SampleGame game = new SampleGame();
		Window window = new Window(1280, 720, "title", game);
		game.addVisual(new Square("square"));
		
		game.resources().add(new ImageResource("BACKGROUND", "/blue.jpg"));
		
		Level pesho = new Level("pesho");
		pesho.setBackground(game.resources().<ImageResource>get("BACKGROUND"));
		game.levels().add(pesho);
		game.levels().setCurrentLevel(pesho);
		
		
	}
}
