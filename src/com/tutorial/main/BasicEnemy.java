package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject{
	private Handler handler;
	private BufferedImage enemy_image;
	
	BasicEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		enemy_image = ss.grabImage(1,2, 72, 56);
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		//handler.addObject(new Trial(x, y, ID.trial, handler, 16, 16, 0.02f,Color.red));
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int)x,(int) y, 16, 16);
		g.drawImage(enemy_image,(int)x,(int) y, null);
		
	}

}
