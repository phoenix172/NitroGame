package nitro.game.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class GraphicsWrapper {

	private Graphics2D graphics;
	private Rectangle bounds;

	public GraphicsWrapper(Graphics2D graphics, Rectangle bounds) {

		this.bounds = bounds;
		if (graphics == null)
			throw new IllegalArgumentException("graphics");
		this.graphics = graphics;
	}

	public GraphicsWrapper(Graphics2D graphics) {
		this(graphics, graphics.getDeviceConfiguration().getBounds());
	}

	public GraphicsWrapper create() {
		return create(bounds.getLocation(), bounds.getSize());
	}

	public GraphicsWrapper create(Point location, Dimension size) {
		return new GraphicsWrapper((Graphics2D) this.graphics.create(location.x, location.y, size.width, size.height));
	}

	public void setBounds(Point location, Dimension size) {
		this.bounds = new Rectangle(location, size);
	}

	public Rectangle bounds() {
		return this.bounds;
	}

	public Graphics2D get() {
		return ((Graphics2D) graphics.create());
	}

	public void dispose() {
		graphics.dispose();
	}
}