package com.paddle.entities;

import java.awt.Color;
import java.awt.Graphics;

import com.paddle.files.IO;
import com.paddle.main.Display;
import com.paddle.main.Game;
import com.paddle.states.GameState;
import com.paddle.states.State;

public class Ball extends Entity {

	//the ball's velocities
	private int velX = -6, velY = -6;

	public Ball(int x, int y) {
		super(x, y);
	}

	protected void init() {
		width = 16;
		height = 16;
	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}

	public void update() {
		//makes ball bounce on the wall
		if (x < 0 || x > Display.WIDTH - width) {
			velX = -velX;
			GameState.score++;
		}
		if (y < 0) {
			velY = -velY;
		}
		if (y > Display.HEIGHT - height) {
		//	IO.checkScore(GameState.score);
			GameState.score = 0;
			Game.state = State.PAUSE;
		}
		
		//updates position
		x += velX;
		y += velY;
	}

	//getters and setters
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

}
