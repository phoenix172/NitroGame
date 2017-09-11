package nitro.game.graphics;

import nitro.game.core.Game;
import nitro.game.core.VisualObject;
import nitro.game.objects.GameObject;

public class Camera {
	private float x, y;

	public Camera(float x, float y, VisualObject followObject) {
		this.x = x;
		this.y = y;
	}

	public void tick(VisualObject object) {
		x = -object + Game.WIDTH / 2;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setX(float x) {
		this.x = x;
	}
}