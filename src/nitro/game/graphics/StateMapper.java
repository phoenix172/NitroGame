package nitro.game.graphics;

import java.util.HashMap;
import java.util.Map;

import nitro.game.objects.StateMachine;
import nitro.game.visuals.Visual;

public class StateMapper implements Visual{
	public Map<String, Visual> mappings;
	private String key;
	private StateMachine stateMachine;
	
	public StateMapper(String key, StateMachine stateMachine) {
		this.key = key;
		this.mappings = new HashMap<String, Visual>();
		this.stateMachine = stateMachine;
		this.stateMachine.subscribeStateChanged(this::stateChanged);
	}
	
	private void stateChanged(String state) {
//		/this.currentVisual = mappings.get(state);
	}
	
	public void addMapping(String state, Visual visual) {
		mappings.put(state, visual);
	}
	
	public void removeMapping(String state) {
		mappings.remove(state);
	}
	
	public Visual currentVisual() {
		return getVisual(stateMachine.currentState());
	}
	
	public Visual getVisual(String state) {
		return mappings.get(state);
	}
	
	public boolean containsMapping(String state) {
		return mappings.containsKey(state);
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public void tick() {
		currentVisual().tick();
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		currentVisual().render(graphicsWrapper);
	}
}
