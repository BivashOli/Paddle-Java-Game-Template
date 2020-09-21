package com.paddle.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.paddle.files.IO;
import com.paddle.inputs.KeyInput;
import com.paddle.inputs.MouseInput;
import com.paddle.states.GameState;
import com.paddle.states.MenuState;
import com.paddle.states.PauseState;
import com.paddle.states.State;

public class Game implements Runnable {


	//display
	private Display display;
	
	//gameloop
	private boolean running = false;
	private Thread thread;
	
	//graphics
	private BufferStrategy bs;
	private Graphics g;

	//states
	public static State state;
	private MenuState menustate;
	private GameState gamestate;
	private PauseState pausestate;

	
	//inputs
	private KeyInput keyInput;
	private MouseInput mouseInput;
	
	//file input and output
	//private IO io;

	
	//when the game constructor is called, it will first initialize all the variables
	//in the init() method, then start the gameloop in the start() method
	public Game() {
		init();
		start();
	}

	//this method is a place to initialize all our global variables BEFORE 
	//we start the gameloop, let's us avoid null pointer exceptions
	private void init() {
		display = new Display();
		state = State.MENU;
		menustate = new MenuState();
		gamestate = new GameState();
		pausestate = new PauseState();
		keyInput = new KeyInput(this);
		mouseInput = new MouseInput(this);
	//	io = new IO();
		display.getCanvas().addKeyListener(keyInput);
		display.getCanvas().addMouseListener(mouseInput); 
		
	}


	//GAME LOOP STUFF
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run() {
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public void render() {
		//set up for every render cycle
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//START RENDERING 
		
		//background set to black, so every frame the screen is painted black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Display.WIDTH+50, Display.HEIGHT+50);
		
		//checks what the current state is and renders that particular state
		System.out.println("state: "+state);
		if (state == State.MENU) {
			System.out.println("menu rendering");
			menustate.render(g);
		} else if (state == State.GAME) {
			gamestate.render(g);
		} else if (Game.state == State.PAUSE) {
			pausestate.render(g);
		}
		//STOP RENDERING
		
		//clean up on every render cycle
		bs.show();
		g.dispose();
	}

	public void update() {
		//checks the current state and updates that particular state
		//this is a very simple game so the only state needing to update is the gamestate
		if (state == State.GAME) {
			gamestate.update();
		}
	}


	//a bunch of getters and setters
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public MenuState getMenustate() {
		return menustate;
	}

	public void setMenustate(MenuState menustate) {
		this.menustate = menustate;
	}

	public GameState getGamestate() {
		return gamestate;
	}

	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}

	public PauseState getPausestate() {
		return pausestate;
	}

	public void setPausestate(PauseState pausestate) {
		this.pausestate = pausestate;
	}

}
