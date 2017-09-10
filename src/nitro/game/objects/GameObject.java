package nitro.game.objects;

import nitro.game.graphics.StateMapper;
import nitro.game.graphics.StaticBackground;
import nitro.game.resources.ImageResource;
import nitro.game.visuals.Visual;

public abstract class GameObject implements Visual {

	protected double x, y;
	protected double width, height;

	private StateMachine stateMachine;
	private StateMapper stateMapper;

	protected StaticBackground sprite;

	private static final String SPRITE = "SPRITE";

	public GameObject(ImageResource imageResouce) {
		this.stateMachine = new StateMachine();
		this.stateMapper = new StateMapper(SPRITE, stateMachine);
		this.sprite = new StaticBackground(imageResouce);
	}

	protected StateMachine stateMachine() {
		return stateMachine;
	}

	protected StateMapper stateMapper() {
		return stateMapper;
	}
}