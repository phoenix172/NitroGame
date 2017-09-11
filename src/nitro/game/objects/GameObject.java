package nitro.game.objects;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.graphics.StateMapper;
import nitro.game.graphics.StaticBackground;
import nitro.game.resources.ImageResource;
import nitro.game.resources.Resource;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.Visual;

public abstract class GameObject implements Visual {

	protected double x, y;
	protected double width, height;

	private StateMachine stateMachine;
	private StateMapper stateMapper;
	protected ResourceDictionary resources;

	private static final String SPRITE = "SPRITE";
	private String key;

	public GameObject(String key, ResourceDictionary resources) {
		this.key = key;
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
		stateMapper.render(graphicsWrapper);
	}
	
	@Override
	public String key() {
		return this.key;
	}

}