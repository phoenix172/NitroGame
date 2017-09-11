package nitro.game.graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import nitro.game.resources.ImageResource;

public class SpriteSheet {
	private ImageResource resource;
	private List<BufferedImage> sprites;

	public SpriteSheet(ImageResource resource, int spriteWidth, int spriteHeight) {
		this.resource = resource;
		this.sprites = new ArrayList<BufferedImage>();
		extractFrames(spriteWidth, spriteHeight);
	}

	private void extractFrames(int width, int height) {
		int x = 0, y = 0;

		while (y + height <= resource.get().getHeight()) {
			while (x + width <= resource.get().getWidth()) {
				this.sprites.add(resource.get().getSubimage(x, y, width, height));
				x += width;
			}
			x = 0;
			y += height;
		}
	}

	public BufferedImage get(int index) {
		return sprites.get(index);
	}

	public List<BufferedImage> getAll() {
		return sprites;
	}
}