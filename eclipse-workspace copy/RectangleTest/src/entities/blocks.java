package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.BlockPanel;

public class blocks extends Rectangle
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public blocks bs;
	
	public blocks(int width, int height)
	 {
		 setBounds(BlockPanel.width/2, BlockPanel.height/2, width, height);
	 }
	 public void draw(Graphics g)
	 {
		 g.setColor(Color.red);
	     g.fillRect(x, y, width, height);
	 }
}
