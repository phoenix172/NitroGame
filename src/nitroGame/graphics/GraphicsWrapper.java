package nitroGame.graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GraphicsWrapper {

	private Graphics2D graphics;

	public GraphicsWrapper(Graphics2D graphics) {
		if(graphics == null)throw new IllegalArgumentException("graphics");
		this.graphics = graphics;
	}

	public Graphics2D create() {
		return (Graphics2D)this.graphics.create();
	}
	
	public Rectangle bounds() {
		return graphics.getDeviceConfiguration().getBounds();
	}
}