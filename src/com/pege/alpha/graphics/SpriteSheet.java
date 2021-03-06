package com.pege.alpha.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/sprites/spritesheet.png", 256);
	public static SpriteSheet projectiles = new SpriteSheet("/sprites/projectiles/projectiles.png", 48);
	public static SpriteSheet goku = new SpriteSheet("/sprites/goku.png", 288);
	
	public SpriteSheet(String path, int size) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
