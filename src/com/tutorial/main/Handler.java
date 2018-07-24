package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	 LinkedList<GameObject> object = new LinkedList<GameObject>();
	 public int speed = 5;
	 
	public void tick()
	{
		for(int i = 0; i < object.size();i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g)
	{
		try
		{
			for(int i = 0; i < object.size();i++)
			{
				GameObject tempObject = object.get(i);
				tempObject.render(g);
			}
		}
		catch(NullPointerException e)
		{
		
		}
	
	}
	
	
	public void clearEnemies()
	{
		for(int i = 0; i < object.size();i++)
		{
			GameObject tempObject = object.get(i);
			if(tempObject.getId() == ID.player) 
			{
				object.clear();
				if(Game.gameState != Game.STATE.end)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.player, this));
			}
		}
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}

}
