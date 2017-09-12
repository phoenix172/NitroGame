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
	private VisualObject parent;
	private Dimension size;
	private Point location;
	public double velocityX;
	private String key;

	public VisualObject() {
		this.key = UUID.randomUUID().toString();
		this.compositeVisual = new CompositeVisual(key);
		this.resourceDictionary = new ResourceDictionary();
	}

	public Collection<VisualObject> children() {
		return compositeVisual.visuals().stream().map(x -> (VisualObject) x).collect(Collectors.toList());
	}

	public void addChild(VisualObject child) {
		child.setParent(this);
		addChild((Visual) child);
		child.onLoaded();
	}
	
	private void setParent(VisualObject parent) {
		this.parent = parent;
		this.resourceDictionary.setParent(parent.resourceDictionary);		
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
	
	public boolean hasParent() {
		return this.parent != null;
	}
	
	public Point getLocation() {
		if(this.location!=null)
			return this.location;
		if(this.hasParent())
			return this.parent.location;
		return null;
	}
	
	
	public Dimension getSize() {
		if(this.size != null)
			return this.size;
		if(this.hasParent())
			return this.parent.size;
		return null;
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
		Point location = this.getLocation();
		location.x += velocityX;
		this.setLocation(location);
		compositeVisual.tick();
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		GraphicsWrapper wrapper = graphicsWrapper.create();
		if(location != null)
			wrapper.bounds().setLocation(location);
		if(size != null)
			wrapper.bounds().setSize(size);
		compositeVisual.render(wrapper);
	}
}
