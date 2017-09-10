package nitro.game.visuals;

import java.util.HashMap;
import java.util.Map;

public class VisualCollection extends HashMap<String, Visual> {
	public void add(Visual visual) {	
		this.put(visual.key(), visual);
	}	
}