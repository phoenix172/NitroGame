package nitroGame.sample;

import nitroGame.Core.Game;
import nitroGame.Core.Window;
import nitroGame.Visuals.Square;

public class SampleGame extends Game{
	public static void main(String[] args) {
		SampleGame game = new SampleGame();
		Window window = new Window(1280, 720, "title", game);
		game.addVisual(new Square());
	}
}
