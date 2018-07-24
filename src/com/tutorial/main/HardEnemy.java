package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HardEnemy extends GameObject{
	private Handler handler;
	private BufferedImage enemy_image;
	
	Random r = new Random();
	
	HardEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		enemy_image = ss.grabImage(2,1,72,56);
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT - 32) 
		{if(velY < 0) velY = -(r.nextInt(5) + 1) * -1; else velY = (r.nextInt(5) + 1) * -1;}
		if(x <= 0 || x >= Game.WIDTH - 16) 
		{if(velX < 0) velX = -(r.nextInt(5) + 1) * -1; else velX = (r.nextInt(5) + 1) * -1;}
		//handler.addObject(new Trial(x, y, ID.trial, handler, 16, 16, 0.02f,Color.yellow));
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect((int)x,(int) y, 16, 16);
		g.drawImage(enemy_image,(int)x,(int) y, null);
	}

}
