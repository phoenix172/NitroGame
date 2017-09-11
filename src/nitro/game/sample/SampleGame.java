package nitro.game.sample;

import java.awt.Point;

import nitro.game.core.Game;
import nitro.game.core.Level;
import nitro.game.graphics.StaticBackground;
import nitro.game.objects.GameObject;
import nitro.game.resources.ImageResource;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Animation;
import nitro.game.visuals.Frame;

public class SampleGame extends Game {
	public SampleGame() {
		setTitle("Sample Game");
		addResources();
		addLevels();
	}

	private void addResources() {
		resources().add(new ImageResource("BACKGROUND", "/blue.jpg"));
		resources().add(new ImageResource("CUBE", "/cube.png"));
	}

	private void addLevels() {
		Level level = new CustomLevel("pesho");
		StaticBackground background = new StaticBackground(resources().get("BACKGROUND"));
		levelManager().addLevel(level);
		levelManager().setCurrentLevel(level);

		GameObject cube = new Cube();
		cube.setLocation(new Point(69,69));
	}
}
