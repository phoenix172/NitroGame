package nitro.game.objects;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.graphics.StateMapper;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Visual;

public abstract class GameObject implements Visual {

	private Rectangle bounds;

	private StateMachine stateMachine;
	private StateMapper stateMapper;
	protected ResourceDictionary resources;

	private static final String SPRITE = "SPRITE";
	private String key;

	public GameObject(String key,ResourceDictionary resources) {
		this.key = key;
		this.bounds = new Rectangle();
		this.stateMachine = new StateMachine();
		this.stateMapper = new StateMapper(SPRITE, stateMachine);
		this.resources = resources;
	}

	protected StateMachine stateMachine() {
		return stateMachine;
	}

	protected StateMapper stateMapper() {
		return stateMapper;
	}

	@Override
	public void tick() {
		stateMapper.tick();
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		stateMapper.render(graphicsWrapper.create(bounds));
	}

	@Override
	public String key() {
		return this.key;
	}
	
	public void setSize(Dimension d) {
		bounds.setSize(d);
	}
	
	public void setLocation(Point p) {
		bounds.setLocation(p);
	}
}