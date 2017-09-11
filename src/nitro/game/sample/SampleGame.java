package nitro.game.sample;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import nitro.game.core.Game;
import nitro.game.core.Level;
import nitro.game.graphics.SpriteSheet;
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
		resources().add(new ImageResource("SPRITE_SHEET", "/player_sheet.png"));
	}

	private void addLevels() {
		Level level = new CustomLevel("pesho");
		StaticBackground background = new StaticBackground(resources().get("BACKGROUND"));

		levels().add(level);
		levels().setCurrentLevel(level);
		level.add(background);

		SpriteSheet spriteSheet = new SpriteSheet(resources().get("SPRITE_SHEET"), 64, 64);
		List<BufferedImage> frames = spriteSheet.getAll();

		resources().add(new ImageResource("frame1", frames.get(0)));
		resources().add(new ImageResource("frame2", frames.get(1)));
		resources().add(new ImageResource("frame3", frames.get(2)));
		resources().add(new ImageResource("frame4", frames.get(3)));
		resources().add(new ImageResource("frame5", frames.get(4)));
		resources().add(new ImageResource("frame6", frames.get(5)));

		GameObject cube = new Cube(resources());
		cube.setLocation(new Point(100, 100));
		level.add(cube);
	}
}