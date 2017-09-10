package nitro.game.graphics;

import java.util.Iterator;
import java.util.stream.Stream;

import nitro.game.visuals.Frame;
import nitro.game.visuals.SelectionVisual;

public class Animation extends SelectionVisual {

	private int speed;
	private Iterator<String> frameIterator;

	private int elapsedTicks = 0;

	public Animation(String key, Frame... frames) {
		super(key);
		this.addRange(frames);
		frameIterator = frames().iterator();
	}

	public Stream<String> frames() {
		return this.values().stream().map(x -> x.key());
	}

	private void next() {
		if (!frameIterator.hasNext())
			frameIterator = frames().iterator();

		this.setActive(this.frameIterator.next());
	}

	@Override
	public void tick() {
		super.tick();
		elapsedTicks++;

		if (elapsedTicks > speed)
			next();
	}
}