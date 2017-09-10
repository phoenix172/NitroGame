package nitroGame.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResource extends Resource<BufferedImage> {

	private String path;

	public ImageResource(String key, String path) {
		super(key);
		this.path = path;
	}

	@Override
	public BufferedImage load() {
		try {
			return ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}