package nitroGame.Core;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow {

	private Game game;
	public GameWindow(int width, int height, Game game) {
		this.game = game;
		game.setPreferredSize(new Dimension(width, height));
		game.setMinimumSize(new Dimension(width, height));
		game.setMaximumSize(new Dimension(width, height));

		JFrame frame = new JFrame(game.title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void run() {
		game.start();
	}
}