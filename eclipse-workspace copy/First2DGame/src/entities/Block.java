package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import first2dgame.MyPanel;

public class Block extends Rectangle
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int BlockWidth=32;
	public static final int BlockHeight=32;
	
	
	public Block(int x, int y)
	{
		setBounds(x,y,BlockWidth,BlockHeight);
	}
	public void draw(Graphics g) 
	{
		g.setColor(Color.yellow);
		g.drawRect(x, y, MyPanel.Width, BlockHeight);
		g.drawRect(200, 450, 400, BlockHeight);
	}
	
}
