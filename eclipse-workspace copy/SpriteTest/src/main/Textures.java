package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {
	
SpriteSheet ps;
private BufferedImage playerSheet=null;

public BufferedImage[] player = new BufferedImage[4];

	public Textures() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			playerSheet = loader.loadImage("slime-Sheet.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		ps=new SpriteSheet(playerSheet);
		
		getTextures();
	}
	private void getTextures() {
		player[0]=ps.grabSprite(0, 0, 32, 25);
		player[1]=ps.grabSprite(32, 0, 32, 25);
		player[2]=ps.grabSprite(64, 0, 32, 25);
		player[3]=ps.grabSprite(96, 0, 32, 25);
		
	}
}
