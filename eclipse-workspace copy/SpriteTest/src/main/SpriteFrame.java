package main;

import javax.swing.JFrame;



public class SpriteFrame extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//BufferedImage sprite;
	
	public SpriteFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new SpritePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
	}
}
