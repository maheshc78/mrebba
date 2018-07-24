package com.tutorial.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private int scorekeep = 0;
	private Game game;
	
	public Spawn(Handler handler, HUD hud, Game game)
	{
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	public void tick()
	{
		scorekeep++;
		if(scorekeep > 100)
		{
			scorekeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			if(game.diff == 0)
			{
				if(hud.getLevel() == 2)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.basicenemy, handler));
				}
				else if(hud.getLevel() == 3)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.basicenemy, handler));
				}
				else if(hud.getLevel() == 4)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 12),r.nextInt(Game.HEIGHT - 12), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 5)
				{
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.smartenemy, handler));
				}
				else if(hud.getLevel() == 6)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 7)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 8)
				{
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.smartenemy, handler));
				}
				else if(hud.getLevel() == 9)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 10)
				{
					handler.clearEnemies();
					handler.addObject(new EnemyBoss(300,5,ID.enemyboss,handler));
				}
			}
			else if(game.diff == 1)
			{
				if(hud.getLevel() == 2)
				{
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.basicenemy, handler));
				}
				else if(hud.getLevel() == 3)
				{
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.basicenemy, handler));
				}
				else if(hud.getLevel() == 4)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 12),r.nextInt(Game.HEIGHT - 12), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 5)
				{
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.smartenemy, handler));
				}
				else if(hud.getLevel() == 6)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 7)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 8)
				{
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.smartenemy, handler));
				}
				else if(hud.getLevel() == 9)
				{
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.fastenemy, handler));
				}
				else if(hud.getLevel() == 10)
				{
					handler.clearEnemies();
					handler.addObject(new EnemyBoss(300,5,ID.enemyboss,handler));
				}
			}
			
			
			
		}
		
		
	}
}
