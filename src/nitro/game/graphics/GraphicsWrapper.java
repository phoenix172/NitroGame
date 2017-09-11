package nitro.game.graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GraphicsWrapper {

	private Graphics2D graphics;

	public GraphicsWrapper(Graphics2D graphics) {
		if(graphics == null)throw new IllegalArgumentException("graphics");
		this.graphics = graphics;
	}

	public GraphicsWrapper create() {
		return create(bounds());
	}
	
	public GraphicsWrapper create(Rectangle bounds) {
		return new GraphicsWrapper((Graphics2D)this.graphics
				.create(bounds.x, bounds.y, bounds.width, bounds.height));
	}
	
	public Rectangle bounds() {
		Rectangle bounds = graphics.getClipBounds();
		if(bounds == null)
			return graphics.getDeviceConfiguration().getBounds();
		return bounds;
	}
	
	public Graphics2D get() {
		return ((Graphics2D)graphics.create());
	}
	
	public void dispose() {
		graphics.dispose();
	}
}