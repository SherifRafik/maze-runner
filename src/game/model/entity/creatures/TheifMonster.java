package game.model.entity.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.controller.Handler;
import game.graphics.Animation;
import game.graphics.Assets;

public class TheifMonster extends Monster {

	//Animations
	private Animation theifAnim;

	public TheifMonster(Handler handler, float x, float y) {
		super(handler, x, y);
		setHealth(1);
		
		//Animations
		theifAnim = new Animation(250, Assets.theifAnim);
	}
	
	String lastState = "Down";
	private BufferedImage getCurrentAnimationFrame() {
		return theifAnim.getCurrentFrame();
	}

	/*
	private BufferedImage getLastStateImage() {
		if(lastState.equals("Left")) {
			return Assets.monster_left[0];
		} else if(lastState.equals("Right")) {
			return Assets.monster_right[0];
		} else if(lastState.equals("Up")) {
			return Assets.monster_up[0];
		} else
			return Assets.monster_down[0];
	}
	//*/

	public void move() {
		xMove = yMove = 0;
		if(lastState.equals("Down")) {
			yMove += speed;
		}
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	@Override
	public void tick() {
		//Animations
		theifAnim.tick();
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		System.out.println("Theif Monster Killed!");
	}
}
