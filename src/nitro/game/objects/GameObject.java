package nitro.game.objects;

import nitro.game.core.VisualObject;
import nitro.game.graphics.StateMapper;

public abstract class GameObject extends VisualObject {
	private StateMachine stateMachine;
	private StateMapper stateMapper;

	private static final String SPRITE = "SPRITE";

	public GameObject() {	
		this.stateMachine = new StateMachine();
		this.stateMapper = new StateMapper(SPRITE, stateMachine);
		this.addChild(stateMapper);
	}

	protected StateMachine stateMachine() {
		return stateMachine;
	}

	protected StateMapper stateMapper() {
		return stateMapper;
	}
}