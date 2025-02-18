package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import first2dgame.MyPanel;

public class ModeState extends GameState
{
	private String[] Options= {"Puzzle", "Pac Man", "Runner", "Back"};
	
	private int currentSelection=0;
	
	public ModeState(GameStateManager gsm) 
	{
		super(gsm);
	}

	@Override
	public void init() {}

	@Override
	public void tick() {}

	@Override
	public void draw(Graphics g) {
		for(int i=0;i<Options.length;i++)
        {
            if(i==currentSelection)
            {
                g.setColor(Color.blue);
            }
            else
            {
                g.setColor(Color.white);
            }
            g.setFont(new Font("Arial", Font.PLAIN, 85));
            g.drawString(Options[i], MyPanel.Width/2-80,120+i*100);
            
        }
		
	}

	@Override
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_W)
        {
            currentSelection--;
            if(currentSelection<0)
            {
                currentSelection=Options.length-1;
            }
        }
        else if(k==KeyEvent.VK_S)
        {
            currentSelection++;
            if(currentSelection>=Options.length)
            {
                currentSelection=0;
            }
        }
        if(k==KeyEvent.VK_ENTER)
        {
            //Puzzle
            if(currentSelection==0)
            {
            	gsm.states.push(new PuzzleState(gsm));
            }

            //Pac Man
            else if(currentSelection==1)
            {
                
            }
            //Runner
            else if(currentSelection==2)
            {
            	
            }
            //Back
            else if(currentSelection==3)
            {
            	gsm.states.push(new MenuState(gsm));
            }
        }
		
	}

	@Override
	public void keyReleased(int k) {}
}
