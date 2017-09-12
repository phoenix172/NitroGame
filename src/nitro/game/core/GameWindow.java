package nitro.game.core;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

	public GameWindow(int width, int height) {
		Dimension size = new Dimension(width, height);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void show(Game game) {
		GameCanvas canvas = new GameCanvas(game);
		add(canvas);
//		canvas.setBackground(Color.black);
		canvas.start();
		super.setVisible(true);
	}
}