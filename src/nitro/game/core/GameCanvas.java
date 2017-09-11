package nitro.game.core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.objects.GameObject;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.CompositeVisual;
import nitro.game.visuals.Visual;

public class GameCanvas extends Canvas {
	
	private boolean running = false;
	private Thread thread;
	private Game game;

	Random rand = new Random();

	public GameCanvas(Game game) {
		this.game = game;
	}
	
	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this::run);
		thread.start();
	}

	protected void run() {
		this.requestFocus();
		
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				game.tick();
				updates++;
				delta--;
			}
			
			GraphicsWrapper graphics = createGraphics();
			game.render(graphics);
			graphics.dispose();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS:" + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private GraphicsWrapper createGraphics() {
		this.createBufferStrategy(3);
		return new GraphicsWrapper((Graphics2D)this.getBufferStrategy().getDrawGraphics());
	}
}