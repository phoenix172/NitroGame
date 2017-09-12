package nitro.game.core;

public abstract class Level extends VisualObject{

	public Level(String name) {
		setKey(name);
	}
	
	@Override
	public int zIndex() {return -1;}
}