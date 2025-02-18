package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import first2dgame.Animation;
import first2dgame.MyPanel;
import textures.WizardTextures;


public class Player
{
	boolean jumping=false, falling=false
			,left=false, right=false, up=false, down=false, idle=true;

	private double JumpSpeed=5;
	private double currentJumpSpeed=JumpSpeed;
	
	private double width=70;
	private double height=99;
	
	private double maxFallSpeed=5;
	private double currentFallSpeed=0.1;
	
	private int facing=1;
	public double velX=0;
	public double velY=0;
	private double x, y;
	WizardTextures tex = MyPanel.getTex();
	private Animation playerIdle, playerWalk, wizJumpLeft, wizIdle
	, wizIdleLeft, wizRunRight, wizRunLeft, wizJump, wizFall;
	
    public Player(double x, double y)
    {
    	
    	this.x=x;
		this.y=y;
		
		wizIdleLeft = new Animation(10, tex.wizardil[0], tex.wizardil[1], tex.wizardil[2]
				, tex.wizardil[3], tex.wizardil[4], tex.wizardil[5], tex.wizardil[6], tex.wizardil[7]);
		wizJumpLeft= new Animation(10, tex.wizardjl[0], tex.wizardjl[1]);
		wizFall=new Animation(10, tex.wizardf[0], tex.wizardf[1]);
		wizJump=new Animation(10, tex.wizardj[0], tex.wizardj[1]);
		wizRunLeft=new Animation(10, tex.wizardrl[0],tex.wizardrl[1],tex.wizardrl[2],tex.wizardrl[3]
				,tex.wizardrl[4],tex.wizardrl[5],tex.wizardrl[6],tex.wizardrl[7]);
		wizRunRight= new Animation(10, tex.wizardrr[0], tex.wizardrr[1], tex.wizardrr[2], tex.wizardrr[3]
				, tex.wizardrr[4], tex.wizardrr[5], tex.wizardrr[6], tex.wizardrr[7]);
		wizIdle=new Animation(10, tex.wizardi[0], tex.wizardi[1], tex.wizardi[2], tex.wizardi[3]
				, tex.wizardi[4], tex.wizardi[5], tex.wizardi[6], tex.wizardi[7]);
    }
    public void draw(Graphics g)
    {
    	if(jumping) {
    		if(facing==1)
    			wizJump.drawAnimation(g, (int)x, (int)y, 70, 82);
    		else if(facing== -1)
    			wizJumpLeft.drawAnimation(g, (int)x, (int)y, 70, 82);
    	}else {
    		if(velX != 0) {
        		if(facing==1)
        			wizRunRight.drawAnimation(g, (int)x, (int)y+35, 65, 62);
        	else
        			wizRunLeft.drawAnimation(g, (int)x, (int)y+35, 65, 62);
        	}else { 
        		if(facing == 1)
        			wizIdle.drawAnimation(g, (int)x, (int)y, 57, 99);
        		else if(facing == -1)
        			wizIdleLeft.drawAnimation(g, (int)x, (int)y, 57, 99);
        	}
    	}
    	
    	Graphics2D g2d =(Graphics2D) g;
    	g.setColor(Color.red);
    	g2d.draw(getBounds());
    	g2d.draw(getBoundsRight());
    	g2d.draw(getBoundsLeft());
    	g2d.draw(getBoundsTop());
    }
    public void tick()
    {
    	x+=velX;
    	y+=velY;
    	
    	if(velX<0) facing=-1;
    	else if(velX>0) facing=1;
    	
    	wizIdleLeft.runAnimation();
    	wizJumpLeft.runAnimation();
    	playerIdle.runAnimation();
    	playerWalk.runAnimation();
    	wizIdle.runAnimation();
    	wizRunRight.runAnimation();
    	wizRunLeft.runAnimation();
    	wizJump.runAnimation();
    	wizFall.runAnimation();
    	
        if(right)
        {
            //x+=3;
        	velX=3;
        }
        if(left)
        {
            //x-=3;
            velX=-3;
        }
        if(up)
        {
            //y-=3;
        	velY=-3;
        }
        if(down)
        {
            //y+=3;
        	velY=3;
        }
        if(jumping)
        {
        	y-=currentJumpSpeed;
        	
        	currentJumpSpeed-=.1;
        		
        	if(currentJumpSpeed<=0)
        	{
        		currentJumpSpeed = JumpSpeed;
        		jumping=false;
        		falling=true;
        	}
        }
        if(falling)
        {
        	y+=currentFallSpeed;
        	
        	if(currentFallSpeed<maxFallSpeed)
        	{
        		currentFallSpeed+=.1;
        	}
        }
        if(!falling)
        {
        	currentFallSpeed=.1;
        }
        
    }
    public void keyPressed(int k)
    {
        if(k==KeyEvent.VK_W) up=true; 
        if(k==KeyEvent.VK_S) down=true; 
        if(k==KeyEvent.VK_A) left=true;
        if(k==KeyEvent.VK_D) right=true;  
        if(k==KeyEvent.VK_SPACE) jumping=true; 
    }
    public void keyReleased(int k)
    {
    	velX=0;
    	velY=0;
        if(k==KeyEvent.VK_W) up=false; 
        if(k==KeyEvent.VK_S) down=false; 
        if(k==KeyEvent.VK_A) left=false; 
        if(k==KeyEvent.VK_D) right=false; 
    }
    public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
    }
    public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
    }
}
