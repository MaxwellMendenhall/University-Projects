package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import states.StatePanel;

public class PacMan extends Rectangle
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	boolean jumping=false, falling=false,left=false, right=false, up=false, down=false;

	private double JumpSpeed=5;
	private double currentJumpSpeed=JumpSpeed;

	private double maxFallSpeed=5;
	private double currentFallSpeed=0.1;

	public PacMan(int width, int height){
		setBounds(StatePanel.width/2, StatePanel.height/2, width, height);
	}
	public void draw(Graphics g) 
	{
	      g.setColor(Color.yellow);
	      g.fillRect(x, y, width, height);

	}

	public void update() {
		if (right)
		{
			x++;
		}
		if (left) {
			x--;
		}
		if (up) {
			y--;
		}
		if (down) {
			y++;
		}
		if (jumping) {
			y -= currentJumpSpeed;

			currentJumpSpeed -= .1;

			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = JumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		if (falling) {
			y += currentFallSpeed;

			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += .1;
			}
		}
		if (!falling) {
			currentFallSpeed = .1;
		}

	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_W)
			up = true;
		if (k == KeyEvent.VK_S)
			down = true;
		if (k == KeyEvent.VK_A)
			left = true;
		if (k == KeyEvent.VK_D)
			right = true;
		if (k == KeyEvent.VK_SPACE)
			jumping = true;
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_W)
			up = false;
		if (k == KeyEvent.VK_S)
			down = false;
		if (k == KeyEvent.VK_A)
			left = false;
		if (k == KeyEvent.VK_D)
			right = false;
	}

}
