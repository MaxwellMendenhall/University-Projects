package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import first2dgame.MyPanel;

public class MenuState extends GameState 
{
	private String[] options={"Start", "Modes", "Quit"};
    
    private int currentSelection = 0;
    
    public MenuState(GameStateManager gsm)
    {
        super(gsm);
    
    }
        @Override
        public void init() {}

        @Override
        public void tick() {}

        @Override
        public void draw(Graphics g) 
        {
            //mess around with the font sizes
            for(int i=0;i<options.length;i++)
            {
                if(i==currentSelection)
                {
                    g.setColor(Color.red);
                }
                else
                {
                    g.setColor(Color.white);
                }
                g.setFont(new Font("Arial", Font.PLAIN, 85));
                g.drawString(options[i], MyPanel.Width/2-80,120+i*100);
                
            }
        }
        @Override
        public void keyPressed(int k) 
        {
            if(k==KeyEvent.VK_W)
            {
                currentSelection--;
                if(currentSelection<0)
                {
                    currentSelection=options.length-1;
                }
            }
            else if(k==KeyEvent.VK_S)
            {
                currentSelection++;
                if(currentSelection>=options.length)
                {
                    currentSelection=0;
                }
            }
            if(k==KeyEvent.VK_ENTER)
            {
                //play
                if(currentSelection==0)
                {
                    gsm.states.push(new Level1State(gsm));
                }

                //quit
                else if(currentSelection==1)
                {
                	gsm.states.push(new ModeState(gsm));
                }
                else if(currentSelection==2)
                {
                	System.exit(0);
                }
            }
        }

        @Override
        public void keyReleased(int k) {}
}
