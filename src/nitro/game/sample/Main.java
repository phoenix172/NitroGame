package nitro.game.sample;

import java.awt.Dimension;
import java.awt.Point;

import nitro.game.core.GameWindow;

public class Main {
	public static void main(String[] args) {
		SampleGame game = new SampleGame();
		game.setSize(new Dimension(1280, 720));
		game.setLocation(new Point(0,0));
		game.onLoaded();
		GameWindow window = new GameWindow(1280, 720);
		window.show(game);
	}
}