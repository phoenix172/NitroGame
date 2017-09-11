package nitro.game.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

public class ImageResource extends Resource<BufferedImage> {

	private String path;

	public ImageResource(String key, String path) {
		super(key);
		this.path = path;
		this.load();
	}
	
	public ImageResource(String key, BufferedImage image) {
		super(key);
		this.value = Optional.of(image);
	}

	@Override
	protected void load() {
		try {
			this.value =  Optional.of(ImageIO.read(getClass().getResource(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}