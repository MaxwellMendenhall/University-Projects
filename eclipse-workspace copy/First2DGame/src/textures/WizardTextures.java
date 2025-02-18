package textures;

import java.awt.image.BufferedImage;
import java.io.IOException;

import first2dgame.BufferedImageLoader;
import first2dgame.SpriteSheet;

public class WizardTextures {
	
	SpriteSheet ps, wf, wj, wi, wil, wrl, wrr, wjl;
	
	private BufferedImage playerSheet=null, wizardFall=null, wizardJump=null
			, wizardIdle=null, wizardIdleLeft=null, wizardRunLeft=null
			, wizardRunRight=null, wizardJumpLeft=null;

	public BufferedImage[] player = new BufferedImage[8];
	public BufferedImage[] wizardf = new BufferedImage[2];
	public BufferedImage[] wizardjl = new BufferedImage[2];
	public BufferedImage[] wizardj = new BufferedImage[2];
	public BufferedImage[] wizardi = new BufferedImage[8];
	public BufferedImage[] wizardil = new BufferedImage[8];
	public BufferedImage[] wizardrl = new BufferedImage[8];
	public BufferedImage[] wizardrr = new BufferedImage[8];

		public WizardTextures() {
			
			BufferedImageLoader loader = new BufferedImageLoader();
			try {
				wizardFall = loader.loadImage("Fall.png");
				wizardJump = loader.loadImage("Jump.png");
				wizardIdle = loader.loadImage("Idle-1.png.png");
				wizardIdleLeft= loader.loadImage("Idle Left.png");
				wizardRunLeft = loader.loadImage("Run Left.png");
				wizardRunRight = loader.loadImage("Run Right.png");
				wizardJumpLeft = loader.loadImage("Jump Left.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			wil= new SpriteSheet(wizardIdleLeft);
			ps=new SpriteSheet(playerSheet);
			wf=new SpriteSheet(wizardFall);
			wj=new SpriteSheet(wizardJump);
			wi=new SpriteSheet(wizardIdle);
			wrl=new SpriteSheet(wizardRunLeft);
			wrr=new SpriteSheet(wizardRunRight);
			wjl=new SpriteSheet(wizardJumpLeft);
			
			getTextures();
		}
		private void getTextures() {
			
			wizardi[0]=wi.grabSprite(0, 0, 57, 97);
			wizardi[1]=wi.grabSprite(249, 0, 57, 97);
			wizardi[2]=wi.grabSprite(499, 0, 57, 97);
			wizardi[3]=wi.grabSprite(749, 0, 57, 97);
			wizardi[4]=wi.grabSprite(999, 0, 57, 97);
			wizardi[5]=wi.grabSprite(1249, 0, 57, 97);
			wizardi[6]=wi.grabSprite(1499, 0, 57, 97);
			wizardi[7]=wi.grabSprite(1749, 0, 57, 97);
			
			wizardil[0]=wil.grabSprite(194, 0, 57, 97);
			wizardil[1]=wil.grabSprite(444, 0, 57, 97);
			wizardil[2]=wil.grabSprite(694, 0, 57, 97);
			wizardil[3]=wil.grabSprite(944, 0, 57, 97);
			wizardil[4]=wil.grabSprite(1193, 0, 57, 97);
			wizardil[5]=wil.grabSprite(1444, 0, 57, 97);
			wizardil[6]=wil.grabSprite(1694, 0, 57, 97);
			wizardil[7]=wil.grabSprite(1943, 0, 57, 97);
			
			wizardrr[0]=wrr.grabSprite(94, 106, 65, 61);
			wizardrr[1]=wrr.grabSprite(342, 105, 67, 62);
			wizardrr[2]=wrr.grabSprite(592, 112, 67, 55);
			wizardrr[3]=wrr.grabSprite(845, 109, 64, 58);
			wizardrr[4]=wrr.grabSprite(1092, 111, 67, 56);
			wizardrr[5]=wrr.grabSprite(1343, 111, 66, 56);
			wizardrr[6]=wrr.grabSprite(1594, 109, 65, 58);
			wizardrr[7]=wrr.grabSprite(1846, 112, 63, 52);
			
			wizardrl[0]=wrl.grabSprite(91, 112, 63, 52);
			wizardrl[1]=wrl.grabSprite(341, 109, 65, 58);
			wizardrl[2]=wrl.grabSprite(591, 111, 66, 56);
			wizardrl[3]=wrl.grabSprite(841, 111, 67, 56);
			wizardrl[4]=wrl.grabSprite(1091, 109, 64, 58);
			wizardrl[5]=wrl.grabSprite(1341, 112, 67, 55);
			wizardrl[6]=wrl.grabSprite(1591, 105, 67, 62);
			wizardrl[7]=wrl.grabSprite(1841, 106, 65, 61);
			
			wizardj[0]=wj.grabSprite(91, 86, 69, 81);
			wizardj[1]=wj.grabSprite(348, 87, 62, 80);
			
			wizardjl[0]=wjl.grabSprite(90, 87, 62, 80);
			wizardjl[1]=wjl.grabSprite(340, 86, 69, 81);
			
			wizardf[0]=wf.grabSprite(107, 81, 65, 86);
			wizardf[1]=wf.grabSprite(357, 88, 64, 79);
			
		}
}
