package textures;

import java.awt.image.BufferedImage;
import java.io.IOException;

import first2dgame.BufferedImageLoader;
import first2dgame.SpriteSheet;

public class TileTextures {
	
	SpriteSheet bt, wt;
	
	public BufferedImage[] backTile= new BufferedImage[3];
	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	private BufferedImage wizardfall=null;
	
	public TileTextures() {
		try {
			wizardfall = loader.loadImage("Fall.png");
		}catch(IOException e){
			
		}
		
	}
}
