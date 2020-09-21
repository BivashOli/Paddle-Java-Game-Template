package com.paddle.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.paddle.main.Game;
import com.paddle.states.State;

public class MouseInput implements MouseListener{

	private Game game;
	
	public MouseInput(Game game) {
		this.game = game;
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX(), y = e.getY();
		if (Game.state == State.MENU) {
			System.out.println("kk");
			if (x >= game.getMenustate().getPlayX() && x <= game.getMenustate().getPlayX() + 200) {
				if (y >= game.getMenustate().getPlayY() && y <= game.getMenustate().getPlayY() + 100) {
					System.out.println("sda");
					Game.state = State.GAME;
				}
			}
			if (x >= game.getMenustate().getExitX() && x <= game.getMenustate().getExitX() + 200) {
				if (y >= game.getMenustate().getExitY() && y <= game.getMenustate().getExitY() + 100) {
					System.exit(1);
				}
			}

		} else if (Game.state == State.PAUSE) {
			if (x >= game.getPausestate().getResumeX() && x <= game.getPausestate().getResumeX() + 400) {
				if (y >= game.getPausestate().getResumeY() && x <= game.getPausestate().getResumeY() + 200) {
					Game.state = State.GAME;
				}
			}
			if (x >= game.getPausestate().getMenuX() && x <= game.getPausestate().getMenuX() + 400) {
				if (y >= game.getPausestate().getMenuY() && y <= game.getPausestate().getMenuY() + 200) {
					Game.state = State.MENU;
					game.getGamestate().reset();
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
