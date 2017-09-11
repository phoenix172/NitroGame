package nitro.game.sample;

import java.awt.Graphics2D;

import nitro.game.core.Game;
import nitro.game.core.Level;
import nitro.game.graphics.Animation;
import nitro.game.graphics.GraphicsWrapper;
import nitro.game.graphics.StaticBackground;
import nitro.game.objects.GameObject;
import nitro.game.resources.ImageResource;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Frame;

public class SampleGame extends Game {
	public SampleGame() {
		this.title = "Sample Game";
		addReasources();
		addLevels();
	}

	private void addReasources() {
		resources().add(new ImageResource("BACKGROUND", "/blue.jpg"));
		resources().add(new ImageResource("CUBE", "/cube.png"));
	}

	private void addLevels() {
		Level level = new CustomLevel("pesho");
		StaticBackground background = new StaticBackground(resources().get("BACKGROUND"));

		levels().add(level);
		levels().setCurrentLevel(level);
		//level.add(background);	
		
		GameObject cube = new Cube(resources());
		level.add(cube);

	}

	public class Cube extends GameObject {
		static final String resourceKey = "CUBE";
		Animation animation;  
		
		public Cube(ResourceDictionary resources) {
			super(resourceKey, resources);
			initStates();
		}

		private void initStates() {
			animation = new Animation("DEFAULT",
					new Frame(resources.get("BACKGROUND")),
					new Frame(resources.get("CUBE")));
			this.stateMapper().addMapping("default", animation);
		}
	}
}
