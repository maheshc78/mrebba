package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static float HEALTH = 100;
	private int score = 0;
	private int level = 1;
	public int bounds = 0;
	
	public void tick()
	{
		
		HEALTH = Game.clamp(HEALTH, 100 + (bounds / 2), 0);
		score++;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(2, 2, 200 + bounds, 32);
		g.setColor(Color.green);
		g.fillRect(2,2, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(2, 2, 200 + bounds, 32);
		g.drawString("Score " + score, 2, 64);
		g.drawString("Level "+ level, 2, 80);
		g.drawString("Space for loop", 2, 94);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
