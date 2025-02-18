package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import entities.blocks;

public class BlockPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int width=500;
	public static int height=500;
	
	public blocks bs;
	
	public BlockPanel()
	{
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.blue);
		this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
        
        init();
        
	}
	public void init() 
	{
		bs=new blocks(30,30);

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		bs.draw(g);
	}

}
