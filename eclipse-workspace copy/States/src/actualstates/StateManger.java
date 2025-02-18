package actualstates;

import java.awt.Graphics;
import java.util.Stack;

public class StateManger 
{
	public Stack<StateState> states;
	public StateManger()
	{
		states=new Stack<StateState>();
		states.push(new Chase(this));
	}
	public void enter() 
	{
		states.peek().enter();
	}
	public void update() 
	{
		states.peek().update();
	}
	public void draw(Graphics g)
	{
		states.peek().draw(g);
	}
	public void start() {
		// TODO Auto-generated method stub
		
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
