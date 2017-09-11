package nitro.game.sample;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import nitro.game.core.Game;
import nitro.game.core.Level;
import nitro.game.graphics.SpriteSheet;
import nitro.game.objects.GameObject;
import nitro.game.resources.ImageResource;

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
		
		levelManager().addLevel(level);
		levelManager().setCurrentLevel(level);

		GameObject cube = new Cube();

		SpriteSheet spriteSheet = new SpriteSheet(resources().get("SPRITE_SHEET"), 64, 64);
		List<BufferedImage> frames = spriteSheet.getAll();

		resources().add(new ImageResource("frame1", frames.get(0)));
		resources().add(new ImageResource("frame2", frames.get(1)));
		resources().add(new ImageResource("frame3", frames.get(2)));
		resources().add(new ImageResource("frame4", frames.get(3)));
		resources().add(new ImageResource("frame5", frames.get(4)));
		resources().add(new ImageResource("frame6", frames.get(5)));
		
		cube.setLocation(new Point(69,69));
	}
}
