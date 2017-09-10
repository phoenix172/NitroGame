package nitroGame.Visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nitroGame.Core.Interfaces.Visual;

public class Square implements Visual {

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics graphics) {
		graphics.setColor(Color.GREEN);
		graphics.drawRect(0, 0, 10, 10);

	}

}
