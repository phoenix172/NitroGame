package nitro.game.visuals;

import java.util.HashMap;
import java.util.Map;

import nitro.game.core.Interfaces.Visual;

public class VisualCollection extends HashMap<String, Visual> {
	public void add(Visual visual) {	
		this.put(visual.key(), visual);
	}	
}