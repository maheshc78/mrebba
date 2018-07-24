package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject{

	private Handler handler;
	private BufferedImage player_image;
	
	Player(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		player_image = ss.grabImage(1,1, 72, 56);	
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
	}

	@Override
	public void tick() {
		x = x + velX;
		y = y + velY;
		
		x = Game.clamp(x, Game.WIDTH - 32, 0);
		y = Game.clamp(y, Game.HEIGHT - 64, 0);
		
		//handler.addObject(new Trial(x, y, ID.trial, handler, 32, 32, 0.05f,Color.white));
		
		collision();
	
	}

	private void collision() {
		for(int i = 0; i < handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.basicenemy || tempObject.getId() == ID.fastenemy  
					||tempObject.getId() == ID.smartenemy 
					||tempObject.getId() == ID.smartenemy )
			{
				if(getBounds().intersects(tempObject.getBounds()))
					HUD.HEALTH -= 2;
			}
		}
		
	}
	@Override
	public void render(Graphics g) {	
			//g.setColor(Color.white);
			//g.fillRect((int)x,(int)y,32,32);
			g.drawImage(player_image,(int)x,(int) y, null);
		
	}
	

}
