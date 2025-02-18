package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import entity.Player;

public class SpritePanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	public Player pl;	

	public int Width=800;
	public int Height=600;
	
	private Thread thread;
    private boolean isRunning=false; 
    private int FPS=60;
    private long targetTime =1000/FPS;
 
    public static Textures tex;
	
	public SpritePanel() {
		this.setPreferredSize(new Dimension(Width,Height));
        this.setBackground(Color.black);
        this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        
        start();
        tex=new Textures();
        pl=new Player(100,100);
	}
	private void start() {
		isRunning=true;
        thread=new Thread(this);
        thread.start();
	}
	private void tick() {
		//pl.tick();
		System.out.println("Running");
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pl.draw(g);
		repaint();
	}
	@Override
	public void run() {
		long start,elapsed,wait;
       
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
		
	}
	public static Textures getTex() {
		return tex;
	}
	
	
}
