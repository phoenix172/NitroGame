package nitroGame.Visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nitroGame.Core.Interfaces.Visual;

public class Square implements Visual {

	String key;
	public Square(String key) {
		this.key = key;
	}
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics graphics) {
		graphics.setColor(Color.GREEN);
		graphics.drawRect(0, 0, 10, 10);

	}
	@Override
	public String key() {
		return key;
	}

}
