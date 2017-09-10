package nitro.game.visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nitro.game.graphics.GraphicsWrapper;

public class Square implements Visual {

	String key;
	public Square(String key) {
		this.key = key;
	}
	@Override
	public void tick() {
		
	}

	@Override
	public void render(GraphicsWrapper graphics) {
		graphics.create().setColor(Color.GREEN);
		graphics.create().drawRect(0, 0, 10, 10);

	}
	@Override
	public String key() {
		return key;
	}

}
