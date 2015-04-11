package com.pege.alpha.entity;

import java.util.Random;

import com.pege.alpha.graphics.Screen;
import com.pege.alpha.graphics.Sprite;
import com.pege.alpha.level.Level;

public abstract class Entity {
	
	protected double x, y;
	protected double speed = 1.0;
	protected boolean removed = false;
	protected Sprite sprite;
	protected Level level;
	protected final Random random = new Random();
	
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
}