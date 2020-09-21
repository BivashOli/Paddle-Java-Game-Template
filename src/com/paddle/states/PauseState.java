package com.paddle.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.paddle.main.Display;

public class PauseState {

	private int resumeX = Display.WIDTH/2-330, resumeY = Display.HEIGHT/2+100;
	private int menuX = Display.WIDTH/2+170, menuY = Display.HEIGHT/2+100;
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Serif", Font.PLAIN, 100)); 
		g.drawString("Paddle", Display.WIDTH/2-130, Display.HEIGHT/2-100);
		
		g.drawRect(resumeX, resumeY, 200, 100);
		g.drawRect(menuX, menuY, 200, 100);
		
		g.setFont(new Font("Serif", Font.PLAIN, 50)); 
		g.drawString("Resume", resumeX+30, resumeY+60);
		g.drawString("Menu", menuX+50, menuY+60);
	}

	public int getResumeX() {
		return resumeX;
	}

	public void setResumeX(int resumeX) {
		this.resumeX = resumeX;
	}

	public int getResumeY() {
		return resumeY;
	}

	public void setResumeY(int resumeY) {
		this.resumeY = resumeY;
	}

	public int getMenuX() {
		return menuX;
	}

	public void setMenuX(int menuX) {
		this.menuX = menuX;
	}

	public int getMenuY() {
		return menuY;
	}

	public void setMenuY(int menuY) {
		this.menuY = menuY;
	}
	
}
