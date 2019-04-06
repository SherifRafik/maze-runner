package game.model.entity.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.controller.Handler;
import game.graphics.Animation;
import game.graphics.Assets;

public class KillerMonster extends Monster {

	//Animations
	private Animation killerAnim;

	public KillerMonster(Handler handler, float x, float y) {
		super(handler, x, y);
		
		//Animations
		killerAnim = new Animation(250, Assets.killerAnim);
	}

	String lastState = "Down";
	private BufferedImage getCurrentAnimationFrame() {
		return killerAnim.getCurrentFrame();
	}

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
		killerAnim.tick();
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		System.out.println("Killer Monster Killed!");
	}
}
