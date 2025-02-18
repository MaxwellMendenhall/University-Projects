
package main;

import javax.swing.JFrame;

public class BlockFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlockFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new BlockPanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
}
