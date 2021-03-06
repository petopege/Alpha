package com.pege.alpha.entity;

import com.pege.alpha.graphics.Screen;
import com.pege.alpha.graphics.Sprite;
import com.pege.alpha.level.Level;

public abstract class Entity {
	
	protected double x, y;
	protected boolean removed = false;
	protected Sprite sprite;
	protected Level level;
	
	public abstract void update();
	
	public abstract void render(Screen screen);
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean removed() {
		return removed;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
