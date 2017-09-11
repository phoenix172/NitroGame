package nitro.game.core;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	public GameWindow(int width, int height) {
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void show(Game game) {
		GameCanvas canvas = new GameCanvas(game);
		pack();
		add(canvas);
	}
}