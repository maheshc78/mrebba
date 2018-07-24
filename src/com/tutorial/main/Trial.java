package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trial extends GameObject{
	private float alpha = 1;
	private Handler handler;
	private int width,height;
	private float life;
	private Color color;
	
	Trial(float x, float y, ID id,Handler handler, int width, int height, float life,Color color) {
		super(x, y, id);
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.life = life;	
		this.color = color;
	}

	@Override
	public void tick() {
		if(alpha > life) alpha -= (life - 0.0001f);
		else handler.removeObject(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		
		g2d.setComposite(makeTransparent(1));
		
	}

	private Composite makeTransparent(float alpha2) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
