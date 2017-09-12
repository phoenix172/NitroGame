package nitro.game.graphics;

import nitro.game.core.VisualObject;

public class Camera {
	private float x, y;
	private VisualObject followObject;

	public Camera() {
	}

	public void follow(float x, float y, VisualObject followObject) {
		this.x = 0;
		this.y = 0;
		this.followObject = followObject;
	}

	public void tick() {
		x -= followObject.velocityX;
		// y = -followObject.getLocation().y + y;

		// followObject.getLocation().x += x;
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