package nitro.game.visuals;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.resources.ImageResource;

public class Frame implements Visual {

	private String key;
	private ImageResource resource;

	public Frame(String key, ImageResource resource) {
		this.key = key;
		this.resource = resource;
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {

		graphicsWrapper.get().drawImage(resource.get(), 0, 0, 32, 32, null);
	}
}
