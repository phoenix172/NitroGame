package nitro.game.objects;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import nitro.game.core.VisualObject;
import nitro.game.graphics.GraphicsWrapper;
import nitro.game.graphics.StateMapper;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Visual;

public abstract class GameObject extends VisualObject {
	private StateMachine stateMachine;
	private StateMapper stateMapper;

	private static final String SPRITE = "SPRITE";

	public GameObject() {	
		this.stateMachine = new StateMachine();
		this.stateMapper = new StateMapper(SPRITE, stateMachine);
		this.children().add(stateMapper);
	}

	protected StateMachine stateMachine() {
		return stateMachine;
	}

	protected StateMapper stateMapper() {
		return stateMapper;
	}
}