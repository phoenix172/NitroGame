package nitro.game.visuals;

import java.util.Iterator;
import java.util.stream.Stream;

public class Animation extends SelectionVisual {

	private int speed;
	private Iterator<String> frameIterator;

	private int elapsedTicks = 0;

	public Animation(int speed, String key, Frame... frames) {
		super(key);
		this.speed = speed;
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

		if (elapsedTicks > speed) {
			next();
			elapsedTicks = 0;
		}
	}
}