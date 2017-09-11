package nitro.game.sample;

import java.awt.Dimension;
import java.awt.Rectangle;

import nitro.game.objects.GameObject;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Animation;
import nitro.game.visuals.Frame;

public class Cube extends GameObject {
	Animation animation;

	public Cube() {
		super();
		this.setSize(new Dimension(32, 32));
		initStates();
	}

	private void initStates() {
		animation = new Animation(10, "DEFAULT", new Frame("frame1", resources().get("BACKGROUND")),
				new Frame("frame2", resources().get("CUBE")));
		this.stateMapper().addMapping("default", animation);
	}
}