package nitroGame.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	
	private Map<String, Resource<?>> resources;
	
	public ResourceManager() {
		resources = new HashMap<String, Resource<?>>();
	}

	public void add(Resource<?> value) {
		resources.put(value.key(), value);
	}
	
	public <T extends Resource<?>> T get(String key) {
		return (T)resources.get(key);
	}
}