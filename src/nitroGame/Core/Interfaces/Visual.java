package nitroGame.Core.Interfaces;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Visual {
	String key();
	void tick();
	void render(Graphics graphics);
}
