package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject{
	private Handler handler;
	private GameObject player;
	private BufferedImage enemy_image;

	SmartEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		velX = 2;
		velY = 9;
		this.handler = handler;
		for(int i = 0; i < handler.object.size(); i++)
		{
			if(handler.object.get(i).getId() == ID.player) player = handler.object.get(i);
		}
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		enemy_image = ss.grabImage(2,3, 72, 56);
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX())
				+ (y - player.getY()) * (y - player.getY()));
		velX = (float) (( -1.0 / distance) * diffX);
		velY = (float) (( -1.0 / distance) * diffY);
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		//handler.addObject(new Trial(x, y, ID.trial, handler, 16, 16, 0.05f,Color.blue));
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect((int)x,(int) y, 16, 16);
		
		g.drawImage(enemy_image,(int)x,(int) y, null);
		
	}

}
