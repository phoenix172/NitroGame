package nitroGame.graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import nitroGame.Core.Interfaces.Visual;
import nitroGame.resources.ImageResource;

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
