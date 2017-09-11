package nitro.game.core;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.UUID;

import nitro.game.graphics.GraphicsWrapper;
import nitro.game.resources.ResourceDictionary;
import nitro.game.visuals.CompositeVisual;
import nitro.game.visuals.Visual;

public class VisualObject implements Visual {
	
	private CompositeVisual children;
	private ResourceDictionary resourceDictionary;
	private Dimension size;
	private Point location;
	private String key;
	
	public VisualObject() {
		this.key = UUID.randomUUID().toString();
		this.children = new CompositeVisual(key);
		this.resourceDictionary = new ResourceDictionary();
	}
	
	protected CompositeVisual children() {
		return children;
	}
	
	protected ResourceDictionary resources() {
		return resourceDictionary;
	}
	
	protected void addChild(VisualObject child) {
		children().add(child);
		child.resources().setParent(this.resources());
	}
	
	public void setSize(Dimension size) {
		this.size = size;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public void setKey(String key){
		this.key = key;
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public void tick() {
		children.tick();
	}

	@Override
	public void render(GraphicsWrapper graphicsWrapper) {
		graphicsWrapper.bounds().setLocation(location);
		graphicsWrapper.bounds().setSize(size);
		children.render(graphicsWrapper);
	}
}
