package com.paddle.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.paddle.main.Game;
import com.paddle.states.State;

public class KeyInput implements KeyListener{

	private Game game;
	
	public KeyInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_D) {
			game.getGamestate().getPlayer().setVelX(15);
		}
		if (keycode == KeyEvent.VK_A) {
			game.getGamestate().getPlayer().setVelX(-15);
		}
		if (keycode == KeyEvent.VK_P) {
			game.setState(State.PAUSE);
		}		
	}

	public void keyReleased(KeyEvent e) {
		game.getGamestate().getPlayer().setVelX(0);
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

	
}
