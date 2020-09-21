package com.paddle.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.paddle.main.Display;

public class Player extends Entity {
	
	//player's velocity in the x position
	private int velX;

	public Player(int x, int y) {
		super(x, y);
	}

	protected void init() {
		//sets width and height
		width = 100;
		height = 20;
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	public void update() {
		//make sure player can't go through the walls
		if (x < 0) {
			x = 0;
		}
		if (x > Display.WIDTH - width) {
			x = Display.WIDTH - width;
		}
		
		//updates position
		x += velX;
	}

	//getter and setter
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

}
