package com.pege.alpha.entity.particle;

import java.util.Random;

import com.pege.alpha.entity.Entity;
import com.pege.alpha.graphics.Screen;
import com.pege.alpha.graphics.Sprite;

public class Particle extends Entity {

	private int life;
	
	private double z;
	private double dx, dy, dz;
	private final Random random = new Random();
	
	public Particle(Sprite sprite, double x, double y, int life) {
		this.x = x;
		this.y = y;
		this.z = random.nextDouble() + 2.0;
		this.life = life + random.nextInt(50);
		
		this.sprite = sprite;
		
		this.dx = random.nextGaussian();
		this.dy = random.nextGaussian();
	}
	
	@Override
	public void update() {
		dz -= 0.1;
		if (z < 0) {
			z = 0;
			dx *= 0.4;
			dy *= 0.4;
			dz *= -0.55;
		}
		
		move(x + dx, y + dy + z + dz);
		
		life--;
		if (life <= 0) {
			remove();
		}
	}
	
	public void move(double x, double y) {
		
		if (tileCollision(x, y)) {
			this.dx *= -0.5;
			this.dy *= -0.5;
			this.dz *= -0.5;
		}
		this.x += dx;
		this.y += dy;
		this.z += dz;
	}
	
	public boolean tileCollision(double x, double y) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = (x - c % 2 * 16) / 16;
			double yt = (y - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c % 2 == 0) ix = (int)Math.floor(xt);
			if (c / 2 == 0) iy = (int)Math.floor(yt);
			solid |= level.getTile(ix, iy).solid();
		}
		return solid;
	}

	@Override
	public void render(Screen screen) {
		screen.renderSprite((int)x, (int)y - (int)z, sprite);
	}

}
