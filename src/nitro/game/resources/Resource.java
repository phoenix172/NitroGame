package nitro.game.resources;

import java.util.Optional;

public abstract class Resource<T> {

	private String key;
	protected Optional<T> value;

	public Resource(String key) {
		this.key = key;
		this.value = Optional.empty();
	}

	public String key() {
		return this.key;
	}

	protected abstract void load();

	public T get() {
		if (value.isPresent())
			return value.get();

		return null;
	}
}