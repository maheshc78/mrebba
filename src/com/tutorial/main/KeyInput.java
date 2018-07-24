package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private boolean keyDown[] = new boolean[4];
	private Game game;
	
	
	KeyInput(Handler handler,Game game)
	{
		this.handler = handler;
		this.game = game;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player)
			{
				if(key == KeyEvent.VK_W){ tempObject.setVelY(- handler.speed); keyDown[0] = true;}
				if(key == KeyEvent.VK_A){tempObject.setVelX(- handler.speed); keyDown[1] = true;}
				if(key == KeyEvent.VK_S){tempObject.setVelY(handler.speed); keyDown[2] = true;}
				if(key == KeyEvent.VK_D){tempObject.setVelX(handler.speed); keyDown[3] = true;}
					
			}
		}
		
		if(key == KeyEvent.VK_P)
		{
			if(Game.gameState == STATE.game)
			{
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
		}
		if(key == KeyEvent.VK_SPACE)
		{
			if(Game.gameState == STATE.game)
				Game.gameState = STATE.shop;
			else if(Game.gameState == STATE.shop)
				Game.gameState = STATE.game;
				
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(0);	
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.player)
			{
				if(key == KeyEvent.VK_W); keyDown[0] = false;
				if(key == KeyEvent.VK_A)keyDown[1] = false;
				if(key == KeyEvent.VK_S)keyDown[2] = false;
				if(key == KeyEvent.VK_D)keyDown[3] = false;		
				
				if(!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
				if(!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);
			}
			
			
		}
	}
}
