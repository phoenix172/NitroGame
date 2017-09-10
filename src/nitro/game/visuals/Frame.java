package nitro.game.visuals;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.resources.ImageResource;

public class Frame implements Visual {

	private ImageResource resource;
	
	public Frame(ImageResource resource) {
		this.resource = resource;
	}

	@Override
	public String key() {
		return null;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {

	}

}
