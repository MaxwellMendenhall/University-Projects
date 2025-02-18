package GameStates;

import java.awt.Graphics;

public abstract class GameState 
{
	protected GameStateManager gsm;
	public static double xOffset, yOffset;
	
    public GameState(GameStateManager gsm)
    {
    	//future me find out what this code does
        this.gsm=gsm;
        init();
    }
    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
}
