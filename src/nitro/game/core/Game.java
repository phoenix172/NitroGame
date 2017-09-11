package nitro.game.core;

import java.awt.GraphicsConfiguration;

import nitro.game.constants.Keys;

public class Game extends VisualObject{

	private LevelManager levelManager;
	private String title;
	
	public Game() {
		setKey(Keys.Game);
		this.levelManager = new LevelManager();
		this.children().add(levelManager);
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
}
