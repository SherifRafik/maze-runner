package game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIBackGround extends UIObject {
	
	private BufferedImage image;
	
	public UIBackGround(float x, float y, int width, int height, BufferedImage image) {
		super(x,y,width,height);
		this.image = image;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		
	}


}
