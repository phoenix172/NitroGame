package nitroGame.resources;

import java.util.HashMap;

public class ResourceManager extends HashMap<String, Resource<?>> {

	public void add(Resource<?> value) {
		this.put(value.key(), value);
	}
	
	public <T extends Resource<?>> T get(String key) {
		return (T) super.get(key);
	}
}