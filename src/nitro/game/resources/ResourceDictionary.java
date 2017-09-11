package nitro.game.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceDictionary  {
	
	private Map<String, ResourceDictionary> dictionaries;
	private Map<String, Resource<?>> resources;
	
	public ResourceDictionary() {
		resources = new HashMap<String, Resource<?>>();
		dictionaries = new HashMap<String, ResourceDictionary>();
	}

	public void add(Resource<?> value) {
		resources.put(value.key(), value);
	}
	
//	public void add(ResourceDictionary dictionary) {
//		dictionaries.put(key, value)
//	}
	
	public <T extends Resource<?>> T get(String key) {
		return (T)resources.get(key);
	} 
}