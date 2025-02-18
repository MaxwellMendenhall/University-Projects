package actualstates;

import java.awt.Graphics;

import entities.PacMan;



public class Chase extends StateState
{
	public PacMan pacman;
	
	public Chase(StateManger sm) 
	{
		super(sm);
	}
	@Override
	public void init() {
		pacman=new PacMan(30,30);
		
	}
	@Override
	public void enter() {}

	@Override
	public void update() {
		pacman.update();
	}

	@Override
	public void draw(Graphics g) 
	{
		pacman.draw(g);
	}
	@Override
	public void keyPressed(int k) {
		pacman.keyPressed(k);
		
	}

	@Override
	public void keyReleased(int k) {
		pacman.keyReleased(k);
		
	}

}
