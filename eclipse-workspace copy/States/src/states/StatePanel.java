package states;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import actualstates.StateManger;

public class StatePanel extends JPanel 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StateManger sm;
	
	public static int width=500;
	public static int height=500;
	
	/**
	private Thread thread;
    private boolean isRunning=false; 
    private int FPS=60;
    private long targetTime =1000/FPS;
	*/
	
	public StatePanel()
	{
		this.setPreferredSize(new Dimension(width,height));
		this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        
        sm=new StateManger();
	}
	public void start() 
	{
		sm.start();
	}
	public void run()
	{
		sm.run();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//sm.draw(g);
		
		//Graphics2D g2d = (Graphics2D) g;
		
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
		
		sm.draw(g);
		
		/**
		g.drawLine(125, 400, 375, 400);
		g.drawLine(125, 400, 125, 250);
		g.drawLine(375, 400, 375, 250);
		g.drawLine(75, 200, 425, 200);
		
		//this is the box that holds the ghosts
		g.drawLine(175, 350, 325, 350);
		g.drawLine(175, 350, 175, 250);
		g.drawLine(175, 250, 225, 250);
		g.drawLine(275, 250, 325, 250);
		g.drawLine(325, 350, 325, 250);
		
		//this is the border of the arena
		g2d.setStroke(new BasicStroke(10));
		g.drawLine(0, 0, 0, 500);
		g.drawLine(0, 0, 500, 0);
		g.drawLine(500, 0, 500, 500);
		g.drawLine(0, 500, 500, 500);
		*/
		
	}

}
