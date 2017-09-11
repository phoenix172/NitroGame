package nitro.game.sample;

import java.awt.Dimension;

import nitro.game.objects.GameObject;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Animation;
import nitro.game.visuals.Frame;

public class Cube extends GameObject {
	static final String resourceKey = "CUBE";
	Animation animation;

	public Cube(ResourceDictionary resources) {
		super(resourceKey, resources);
		this.setSize(new Dimension(128, 128));
		initStates();
	}

	private void initStates() {
		animation = new Animation(5, "DEFAULT", new Frame("frame1", resources.get("frame1")),
				new Frame("frame3", resources.get("frame3")), new Frame("frame4", resources.get("frame4")),
				new Frame("frame5", resources.get("frame5")), new Frame("frame6", resources.get("frame6")));
		this.stateMapper().addMapping("default", animation);
	}
}