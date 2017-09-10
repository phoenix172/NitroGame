package nitro.game.sample;

import java.awt.Graphics2D;

import nitro.game.core.Game;
import nitro.game.core.Level;
import nitro.game.graphics.GraphicsWrapper;
import nitro.game.graphics.StaticBackground;
import nitro.game.objects.GameObject;
import nitro.game.resources.ImageResource;

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
		level.add(background);
		
		GameObject cube = new Cube(resources().get("CUBE"));
		level.add(cube);

	}

	public class Cube extends GameObject {

		public Cube(ImageResource imageResouce) {
			super(imageResouce);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String key() {
			return "cube";
		}

		@Override
		public void tick() {			
		}

		@Override
		public void render(GraphicsWrapper graphicsWrapper) {
			Graphics2D g2 = graphicsWrapper.create();
			g2.drawImage(sprite.image.get(), 0, 0, (int)64, (int)64, null);
		}

	}
}
