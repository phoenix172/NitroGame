package nitro.game.sample;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.objects.GameObject;
import nitro.game.visuals.Animation;
import nitro.game.visuals.Frame;

public class Pesho extends GameObject {
	Animation animation;

	public Pesho() {
		super();
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
	@Override
	public void render(GraphicsWrapper graphicsWrapper) {		
		super.render(graphicsWrapper);
	}

	@Override
	protected void onLoaded() {
		animation = new Animation(5, "DEFAULT", new Frame("frame1", resources().get("frame1")),
				new Frame("frame3", resources().get("frame3")), new Frame("frame4", resources().get("frame4")),
				new Frame("frame5", resources().get("frame5")), new Frame("frame6", resources().get("frame6")));
		this.stateMapper().addMapping("default", animation);
	}
}