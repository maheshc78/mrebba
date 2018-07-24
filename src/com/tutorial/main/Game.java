package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	public static final int WIDTH = 640, HEIGHT = WIDTH /12 * 9;
	private Thread thread;
	private boolean running  = false;
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	public static BufferedImage sprite_sheet;
	
	public static boolean paused = false;
	public int diff = 0;
	
	public enum STATE
	{
		menu,game,help,end,select,shop
	};
	
	public static STATE gameState = STATE.menu;
	public Game()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		try
		{
		sprite_sheet = loader.loadImage("/mons_preview.png");
		System.out.println("loaded");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		handler = new Handler();
		new Window(WIDTH,HEIGHT,"WAVE",this);
		r = new Random();
		hud = new HUD();
		shop = new Shop(handler, hud);
		spawner = new Spawn(handler, hud, this);
		
			
		this.addKeyListener(new KeyInput(handler,this));
		this.addMouseListener(new Menu(this, handler,hud));
		this.addMouseListener(shop);
		menu = new Menu(this, handler,hud);
		
		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();
		
		if(gameState == STATE.game)
		{
		handler.addObject(new Player(WIDTH/2 - 32,HEIGHT/2 - 32,ID.player,handler));
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.basicenemy,handler));
		}
		else if(gameState == STATE.menu)
		{
			for(int i = 0; i < 10; i++)
			handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.menuparticle,handler));
		}
		
	}
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop()
	{
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			if(running)
				render(); 
			frames++;
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: "+ frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick()
	{
		 
		if(gameState == STATE.game)
		{
			if(!paused)
			{
				hud.tick();
				spawner.tick();
				handler.tick();
				
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					gameState = STATE.end;
					handler.clearEnemies();
					for(int i = 0; i < 10; i++)
					handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.menuparticle,handler));
			
				}
			}
			
		}
		else if(gameState == STATE.menu || gameState == STATE.end || gameState == STATE.select)
		{
			menu.tick();
			handler.tick();
		}
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,WIDTH, HEIGHT);
		
		if(paused)
		{
			g.setColor(Color.white);
			g.drawString("PAUSED", 100, 100);
		}
			
			
		if(gameState == STATE.game)
		{
			hud.render(g);
			handler.render(g);
		}
		
		else if(gameState == STATE.shop)
		{
			shop.render(g);
		}
		
		else if(gameState == STATE.menu || gameState == STATE.help || gameState == STATE.end  || gameState == STATE.select)
		{
			try
			{
				menu.render(g);
				handler.render(g);
			}
			catch(NullPointerException e)
			{
				
			}
		}
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var,float max, float min)
	{
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
		
	}
	public static void main(String args[])
	{
		new Game();
	}
}
