package nitro.game.sample;

import nitro.game.core.GameWindow;

public class Main {
	public static void main(String[] args) {
		SampleGame game = new SampleGame();
		GameWindow window = new GameWindow(1280, 720, game);
		window.run();
	}
}