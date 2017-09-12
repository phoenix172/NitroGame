package nitro.game.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import nitro.game.constants.Keys;
import nitro.game.graphics.Camera;
import nitro.game.graphics.GraphicsWrapper;
import nitro.game.sample.Pesho;

public class Game extends VisualObject {

	private LevelManager levelManager;
	private String title;
	private Camera camera;

	public Game() {
		setKey(Keys.Game);
		this.levelManager = new LevelManager();
		camera = new Camera();
	}
	
	@Override
	protected void onLoaded() {
		super.onLoaded();
	}

	protected LevelManager levelManager() {
		return levelManager;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public Camera camera() {
		return this.camera;
	}
	
	@Override
	public void tick() {
		camera.tick();
		super.tick();
	}
	
	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		Graphics2D graphics = graphicsWrapper.get();
//		graphics.setColor(Color.WHITE);
//	graphics.fill(graphicsWrapper.bounds());

		graphics.translate(camera.getX(), camera.getY()); // beginning of cam
		graphics.clearRect((int)camera.getX(),(int)camera.getY(),
				(int)camera.getX() + this.getSize().width,
				(int)camera.getY() + this.getSize().height);

		graphicsWrapper = new GraphicsWrapper(graphics); 
		super.render(graphicsWrapper);

		graphics.translate(-camera.getX(), -camera.getY()); // end of cam
	}
}
