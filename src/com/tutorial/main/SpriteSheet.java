package com.tutorial.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sprite;
	
	SpriteSheet(BufferedImage ss)
	{
		this.sprite = ss;
	}

	public BufferedImage grabImage(int row,int col, int width, int height)
	{
		BufferedImage img = sprite.getSubimage((row * 74 ) - 74 ,(col * 60) - 60, width, height);
		return img;
	}
	
}
