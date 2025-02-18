package actualstates;

import java.awt.Graphics;

public abstract class StateState 
{
	protected StateManger sm;
	public StateState(StateManger sm)
	{
		this.sm=sm;
		init();
	}
	public abstract void init();
	public abstract void enter();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
}
