package nitroGame.graphics;

import java.awt.Graphics2D;

public class GraphicsWrapper {

	private Graphics2D graphics;

	public GraphicsWrapper(Graphics2D graphics) {
		this.graphics = graphics;
	}

	public Graphics2D create() {
		return (Graphics2D)this.graphics.create();
	}
}