package nitro.game.graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import nitro.game.resources.ImageResource;
import nitro.game.visuals.Visual;

public class StaticBackground implements Visual {
	public ImageResource image;

	public StaticBackground(ImageResource image) {
		this.image = image;
	}

	@Override
	public String key() {
		return image.key();
	}

	public int zIndex() {
		return -1;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		Graphics2D graphics = graphicsWrapper.create();
		Rectangle screenBounds = graphicsWrapper.bounds();
		graphics.drawImage(image.get(), 0, 0, (int) screenBounds.getWidth(), (int) screenBounds.getHeight(), null);
	}
}
