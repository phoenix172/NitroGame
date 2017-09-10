package nitro.game.graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import nitro.game.core.Interfaces.Visual;
import nitro.game.resources.ImageResource;

public class StaticBackground implements Visual{
	public ImageResource image;
	public StaticBackground(ImageResource image) {
		this.image = image;
	}
	
	@Override
	public String key() {
		return image.key();
	}

	@Override
	public void tick() {}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		Graphics2D graphics = graphicsWrapper.create();
		Rectangle screenBounds = graphicsWrapper.bounds();
		graphics.drawImage(image.get(), 0, 0, 
				(int) screenBounds.getWidth(),
				(int) screenBounds.getHeight(), null);
	}
}
