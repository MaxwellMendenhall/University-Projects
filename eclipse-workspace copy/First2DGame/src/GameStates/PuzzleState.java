package GameStates;

import java.awt.Color;
import java.awt.Graphics;

import entities.Player;

public class PuzzleState extends GameState {
	public Player player;

	public PuzzleState(GameStateManager gsm) 
	{
		super(gsm);
	}

	@Override
	public void init() {
		//player=new Player(30,30);

	}

	@Override
	public void tick() {
		player.tick();

	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
		
		g.setColor(Color.blue);
		
		//first lane
		g.drawLine(0, 50, 50, 50);
		g.drawLine(100, 50, 200, 50);
		g.drawLine(250, 50, 300, 50);
		g.drawLine(350, 50, 450, 50);
		
		//second lane
		g.drawLine(50, 100, 50, 300);
		g.drawLine(50, 100, 150, 100);
		g.drawLine(150, 100, 150, 150);
		g.drawLine(100, 150, 150, 150);
		g.drawLine(100, 200, 200, 200);
		g.drawLine(100, 200, 100, 300);
		g.drawLine(200, 200, 200, 50);

	}

	@Override
	public void keyPressed(int k) {
		player.keyPressed(k);

	}

	@Override
	public void keyReleased(int k) {
		player.keyReleased(k);

	}

}
