package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss extends GameObject{
	
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	private Random r = new Random();
	private BufferedImage enemy_image;
	
	EnemyBoss(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		velX = 0;
		velY = 1;
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		enemy_image = ss.grabImage(1,3, 72, 56);
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if(timer <= 0) velY = 0;
		else timer --;
		
		if(timer <= 0) timer2 --;
		if(timer2 <= 0) 
		{
			if(velX == 0) velX = 2;
			
			if(velX > 0) velX += 0.05f;
			else if(velX < 0) velX -= 0.05f;
			
			velX = Game.clamp(velX,10,-10);
			
			int  spawn = r.nextInt(10);
			if(spawn == 0) 
			handler.addObject(new EnemybossBullet((int)x + 48,
					(int)y + 48, ID.basicenemy, handler));
		}
		
		if(y <= 0 || y >= Game.HEIGHT - 57) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 40) velX *= -1;
		//handler.addObject(new Trial(x, y, ID.trial, handler, 96, 96, 0.05f,Color.red));
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int)x,(int) y, 64, 64);
		g.drawImage(enemy_image,(int)x,(int) y, null);
		
	}

}
