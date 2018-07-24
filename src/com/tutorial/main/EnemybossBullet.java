package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemybossBullet extends GameObject{
	private Handler handler;
	private Random r = new Random();
	
	EnemybossBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		velX = (r.nextInt(5 - -5) - 5);
		velY = 5;
		this.handler = handler;
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if(y >= Game.HEIGHT - 32) handler.removeObject(this);
		
		handler.addObject(new Trial(x, y, ID.trial, handler, 16, 16, 0.05f,Color.red));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
		
	}

}
