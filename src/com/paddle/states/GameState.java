package com.paddle.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.paddle.entities.Ball;
import com.paddle.entities.Player;
import com.paddle.files.IO;
import com.paddle.main.Display;

public class GameState{

	public static int score = 0;

	private Player player;
	private Ball ball;

	private Rectangle playerRect, ballRect;
	

	public GameState() {
		init();
	}

	protected void init() { 
		player = new Player(Display.WIDTH/2, Display.HEIGHT - 40);
		ball = new Ball(Display.WIDTH/2, Display.HEIGHT/5);
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Serif", Font.BOLD, 25));
		g.drawString("Score: " + String.valueOf(score), 25, 25);
		
		player.render(g);
		ball.render(g);
	}

	public void update() {
		player.update();
		ball.update();
		playerRect = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		ballRect = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		collision();
	}

	//checks player and ball collision and makes ball bounce
	private void collision() {
		if (ballRect.intersects(playerRect)) {
			ball.setVelY(-ball.getVelY()); 
		}
	}
	public void reset(){
		player.setX(Display.WIDTH/2);
		player.setY(Display.HEIGHT - 40);
		ball.setX(Display.WIDTH/2);
		ball.setY(Display.HEIGHT/5);
		score = 0;
	}
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

}
