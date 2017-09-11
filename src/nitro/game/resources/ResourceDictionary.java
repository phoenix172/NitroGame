package nitro.game.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceDictionary  {
	
	private Map<String, Resource<?>> resources;
	private ResourceDictionary parentDictionary;	
	
	public ResourceDictionary() {
		resources = new HashMap<String, Resource<?>>();
	}

	public void add(Resource<?> value) {
		resources.put(value.key(), value);
	}
	
	public void setParent(ResourceDictionary parentDictionary) {
		this.parentDictionary = parentDictionary;
	}
	
	public <T extends Resource<?>> T get(String key) {
		if(resources.containsKey(key))
			return (T)resources.get(key);
		else if(parentDictionary!=null)
			return (T)parentDictionary.get(key);
		else
			return null;
	} 
}