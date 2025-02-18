package states;

import javax.swing.JFrame;


public class Stateframe extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Stateframe()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new StatePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}

}
