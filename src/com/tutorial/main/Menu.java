package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	
	public Menu(Game game,Handler handler,HUD hud)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(game.gameState == STATE.menu)
		{
			if(mouseOver(mx, my, 210, 150, 200, 64)){
				//game.gameState = STATE.game;
				//handler.addObject(new Player(Game.WIDTH/2 - 32,Game.HEIGHT/2 - 32,ID.player,handler));
			    //handler.clearEnemies();
				//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.basicenemy,handler));
				
				//AudioPlayer.getSound("menu_sound").play();
				game.gameState =STATE.select;
				return; 
			}
			
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(1);
			}
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				 game.gameState =	 STATE.help;
				 
				 //AudioPlayer.getSound("menu_sound").play();
			}
		}
		if(game.gameState == STATE.select)
		{
			if(mouseOver(mx, my, 210, 150, 200, 64)){
				game.gameState = STATE.game;
				handler.addObject(new Player(Game.WIDTH/2 - 32,Game.HEIGHT/2 - 32,ID.player,handler));
			    handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.basicenemy,handler));
				game.diff = 0;
				//AudioPlayer.getSound("menu_sound").play();
		
			}
			
			if(mouseOver(mx, my,210,350, 200, 64)){
				game.gameState = STATE.menu;
				return; 
			}
			
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				game.gameState = STATE.game;
				handler.addObject(new Player(Game.WIDTH/2 - 32,Game.HEIGHT/2 - 32,ID.player,handler));
			    handler.clearEnemies();
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.basicenemy,handler));
				game.diff = 1;
				 //AudioPlayer.getSound("menu_sound").play();
			}
		}
		if(game.gameState == STATE.help)
		{
			if(mouseOver(mx, my, 210, 350, 200, 64))
				game.gameState = STATE.menu;
			//AudioPlayer.getSound("menu_sound").play();
			
		}
		
		if(game.gameState == STATE.end)
		{
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				game.gameState = STATE.menu;
				hud.setLevel(1);
				hud.setScore(0);
				
				//	AudioPlayer.getSound("menu_sound").play();
			}
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx,int my,int x,int y,int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public void tick(){
		
	}

	public void render(Graphics g)
	{
	
		if(game.gameState == STATE.menu)
		{
		Font f = new Font("arial", 1,50);
		
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("MENU", 240, 70);
		
		g.drawRect(210,150, 200, 64);
		g.drawString("Play", 260, 200);
		
		g.drawRect(210,250, 200, 64);
		g.drawString("Help", 260,300);
	
		g.drawRect(210,350, 200, 64);
		g.drawString("Quit", 260, 400);
		}
		else if(game.gameState == STATE.help)
		{
			Font f = new Font("arial", 1,50);
			Font f2 = new Font("arial",1 , 25);
			g.setFont(f);
			g.setColor(Color.white);
			g.drawString("Help", 240, 70);
			g.setFont(f2);
			g.drawString("USE WASD keys to move player & dodge enemies", 15, 200);
			g.setFont(f);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 250, 400);
		}
		else if(game.gameState == STATE.end)
		{
			Font f = new Font("arial", 1,50);
			Font f2 = new Font("arial",1 , 25);
			g.setFont(f);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 180, 70);
			g.setFont(f2);
			g.drawString("You lost with a score of "+ hud.getScore(), 120, 200);
			g.setFont(f2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 250, 390);
		}
		else if(game.gameState == STATE.select)
		{
		Font f = new Font("arial", 1,50);
		
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("SELECT DIFFICULTY", 100, 70);
		
		g.drawRect(210,150, 230, 64);
		g.drawString("NORMAL", 220, 200);
		
		g.drawRect(210,250, 200, 64);
		g.drawString("HARD", 220,300);
	
		g.drawRect(210,350, 200, 64);
		g.drawString("BACK", 220, 400);
		}
	}
	
}
