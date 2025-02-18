package entity;

import java.awt.Graphics;
import main.SpritePanel;
import main.Textures;

public class Player 
{
	/**public BufferedImage sprite1;
	public BufferedImage sprite2;
	public BufferedImageLoader loader = new BufferedImageLoader();
	public BufferedImage spriteSheet1=null;
	*/
	//private double x,y;
	
	Textures tex = SpritePanel.getTex();
	
	public Player(double x,double y) {
		//this.x=x;
		//this.y=y;
		//init();
	}
	//public void init() {
		/**try {
			spriteSheet1 = loader.loadImage("slime-Sheet.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpriteSheet ss1 = new SpriteSheet(spriteSheet1);
		
		sprite1=ss1.grabSprite(0, 0, 32, 25);
		*/
	//}
	public void draw(Graphics g) {
		g.drawImage(tex.player[0], 50, 50, 50, 50, null);
		g.drawImage(tex.player[1], 100, 100, 50, 50, null);
		g.drawImage(tex.player[2], 150, 150, 50, 50, null);
		g.drawImage(tex.player[3], 200, 200, 50, 50, null);
		//g.drawImage(sprite2, (int)x, (int)y, 300, 300, null);
		
	}
	
}
