package nitroGame.Visuals;

import java.util.HashMap;
import java.util.Map;

import nitroGame.Core.Interfaces.Visual;

public class VisualCollection extends HashMap<String, Visual> {
	public void add(Visual visual) {	
		this.put(visual.key(), visual);
	}	
}