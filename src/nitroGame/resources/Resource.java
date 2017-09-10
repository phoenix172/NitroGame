package nitroGame.resources;

import java.util.Optional;

public abstract class Resource<T> {

	private String key;
	private Optional<T> value;

	public Resource(String key) {
		this.key = key;
		this.value = Optional.empty();
	}

	public String key() {
		return this.key;
	}

	protected abstract T load();

	public T get() {
		if (!value.isPresent())
			value = Optional.ofNullable(load());

		return value.get();
	}
}