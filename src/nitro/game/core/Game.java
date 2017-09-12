package nitro.game.core;

import java.awt.Color;
import java.awt.Graphics2D;

import nitro.game.constants.Keys;
import nitro.game.graphics.GraphicsWrapper;

public class Game extends VisualObject{

	private LevelManager levelManager;
	private String title;
	
	public Game() {
		setKey(Keys.Game);
		this.levelManager = new LevelManager();
		//this.addChild(levelManager.leve);
	}
	
	protected LevelManager levelManager() {
		return levelManager;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		Graphics2D graphics = graphicsWrapper.get();
		graphics.setColor(Color.WHITE);
		graphics.fill(graphicsWrapper.bounds());
		super.render(graphicsWrapper);
	}
}
