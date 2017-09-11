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

public abstract class Game extends Canvas implements Runnable {

	private static final String GameVisuals = "GAME_VISUALS";
	protected String title;
	private CompositeVisual visuals;
	
	private ResourceDictionary resources;

	private boolean running = false;
	private Thread thread;

	Random rand = new Random();

	public Game() {
		visuals = new CompositeVisual(GameVisuals);
		visuals.add(new LevelManager());
		resources = new ResourceDictionary();
	}

	public LevelManager levels() {
		return (LevelManager) visuals.get(LevelManager.LEVEL_MANAGER_KEY);
	}
	
	public ResourceDictionary resources() {
		return this.resources;
	}

	public void addVisual(Visual visual) {
		visuals.add(visual);
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
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
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS:" + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	private void tick() {
		visuals.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) g;

		GraphicsWrapper graphicsWrapper = new GraphicsWrapper(g2);

		visuals.render(graphicsWrapper);

		g.dispose();
		bs.show();
	}
	
	public String getTitle() {
		return this.title;
	}
}