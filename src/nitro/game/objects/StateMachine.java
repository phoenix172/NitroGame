package nitro.game.objects;

import java.util.Optional;
import java.util.function.Consumer;

public class StateMachine {
	String currentState = "default";
	Optional<Consumer<String>> stateChangedCallback;

	public StateMachine() {
		this.stateChangedCallback = Optional.empty();
	}

	public String currentState() {
		return currentState;
	}

	public void setState(String state) {
		currentState = state;
		if (currentState == state)
			return;

		currentState = state;
		stateChanged();
	}

	public void subscribeStateChanged(Consumer<String> callback) {

		if (this.stateChangedCallback.isPresent())
			this.stateChangedCallback = Optional.of(this.stateChangedCallback.get().andThen(callback));
		else
			this.stateChangedCallback = Optional.of(callback);
	}

	private void stateChanged() {
		if (this.stateChangedCallback.isPresent())
			this.stateChangedCallback.get().accept(currentState);
	}
}
