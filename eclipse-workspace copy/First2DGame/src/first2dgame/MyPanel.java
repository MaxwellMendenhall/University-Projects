package first2dgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameStates.GameStateManager;
import textures.WizardTextures;



public class MyPanel extends JPanel implements KeyListener, Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7833902410593645217L;
	
	//size of game
	public static int Width=800;
    public static int Height=600;
    
    //game loop
    private Thread thread;
    private boolean isRunning=false; 
    private int FPS=60;
    private long targetTime =1000/FPS;
    
    //level manager
    private GameStateManager gsm;   
    
    //images and textures in game
    BufferedImage sprite;
    public static WizardTextures tex;
    
    //object
    
	public MyPanel()
	{
		this.setPreferredSize(new Dimension(Width,Height));
        this.setBackground(Color.black);
        this.addKeyListener(this);
        this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        
        start();
        tex=new WizardTextures();
	    
	}
	private void start()
	{
		isRunning=true;
        thread=new Thread(this);
        thread.start();
	}
	@Override
	public void run() 
	{
		
		long start,elapsed,wait;
        
        gsm= new GameStateManager();
        
        //this is the game loop, allows everything to move be constantly displaying new frames
        while(isRunning)
        {
            start=System.nanoTime();
            
            tick();
            repaint();
            
            elapsed=System.nanoTime()-start;
            wait=targetTime-elapsed/1000000;
            
            if(wait<=0)
            {
                wait=5;
            }
            
            try
            {
                Thread.sleep(wait);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        //call the render method
	}

	private void tick() 
	{
		gsm.tick();
        System.out.println("Running");
	}
	public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        gsm.draw(g);
    }
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		gsm.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		gsm.keyReleased(e.getKeyCode());
	}
	public static WizardTextures getTex() {
		return tex;
	}
}
