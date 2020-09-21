package com.paddle.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.paddle.files.IO;
import com.paddle.main.Display;

public class MenuState {
	
	private int playX = Display.WIDTH/2-330, playY = Display.HEIGHT/2+100;
	private int exitX = Display.WIDTH/2+170, exitY = Display.HEIGHT/2+100;
	
	public void render(Graphics g){
		/*
		 * g.setColor(Color.WHITE); g.setFont(new Font("Serif", Font.BOLD, 25));
		 * g.drawString("Score: " + String.valueOf(IO.highScore()), 25, 25);
		 */
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.PLAIN, 100)); 
		g.drawString("Paddle", Display.WIDTH/2-130, Display.HEIGHT/2-100);
		
		g.drawRect(playX, playY, 200, 100);
		g.drawRect(exitX, exitY, 200, 100);
		
		g.setFont(new Font("Serif", Font.PLAIN, 50)); 
		g.drawString("Play", playX+60, playY+60);
		g.drawString("Exit", exitX+60, exitY+60);
	}

	public int getPlayX() {
		return playX;
	}

	public void setPlayX(int playX) {
		this.playX = playX;
	}

	public int getPlayY() {
		return playY;
	}

	public void setPlayY(int playY) {
		this.playY = playY;
	}

	public int getExitX() {
		return exitX;
	}

	public void setExitX(int exitX) {
		this.exitX = exitX;
	}

	public int getExitY() {
		return exitY;
	}

	public void setExitY(int exitY) {
		this.exitY = exitY;
	}
}
