package GameStates;

import java.awt.Graphics;

import entities.Block;
import entities.Player;
import entities.Test;
import first2dgame.MyPanel;
import framework.Handler;
import framework.ObjectID;

public class Level1State extends GameState
{
	public Player player;
	
	private Block b1;
	
	public Handler handler;
    
    public Level1State(GameStateManager gsm)
    {
        super(gsm);
    }

	@Override
	public void init() 
	{
		//player=new Player(0,0);
		b1=new Block(0,MyPanel.Height-32);
		
		handler = new Handler();
		
		handler.addObject(new Test(100,100, ObjectID.Test));
		

	}

	@Override
	public void tick() 
	{
		//player.tick();
		handler.tick();
	}

	@Override
	public void draw(Graphics g) 
	{
		//player.draw(g);
		b1.draw(g);
		handler.render(g);
	}

	@Override
	public void keyPressed(int k) 
	{
		//player.keyPressed(k);
		handler.keyPressed(k);

	}

	@Override
	public void keyReleased(int k) 
	{
		//player.keyReleased(k);
		handler.keyReleased(k);

	}

}
