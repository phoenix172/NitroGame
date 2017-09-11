package nitro.game.core;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.CompositeVisual;
import nitro.game.visuals.Visual;

public class VisualObject implements Visual {

	private CompositeVisual compositeVisual;
	private ResourceDictionary resourceDictionary;
	private Dimension size;
	private Point location;
	private String key;

	public VisualObject() {
		this.location = new Point();
		this.size = new Dimension();
		this.key = UUID.randomUUID().toString();
		this.compositeVisual = new CompositeVisual(key);
		this.resourceDictionary = new ResourceDictionary();
	}

	public Collection<VisualObject> children() {
		return compositeVisual.visuals().stream().map(x -> (VisualObject) x).collect(Collectors.toList());
	}

	public void addChild(VisualObject child) {
		child.resourceDictionary.setParent(resourceDictionary);
		addChild((Visual) child);
		child.onLoaded();
	}

	public void addChild(Visual visual) {
		compositeVisual.addVisual(visual);
	}

	public void removeChild(Visual child) {
		compositeVisual.removeVisual(child);
	}

	public VisualObject getChild(String key) {
		return (VisualObject) compositeVisual.getVisual(key);
	}

	protected ResourceDictionary resources() {
		return resourceDictionary;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public void setKey(String key) {
		this.key = key;
	}

	protected void onLoaded() {
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public void tick() {
		compositeVisual.tick();
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		graphicsWrapper.setBounds(location, size);
		compositeVisual.render(graphicsWrapper);
	}
}
