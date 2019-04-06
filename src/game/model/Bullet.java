package game.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;

import game.controller.Handler;
import game.graphics.Assets;
import game.model.entity.Entity;
import game.model.entity.creatures.Monster;

public class Bullet {
	
	private float x;
	private float y;
	private String directionOfBullet;
	private Rectangle bounds;
	private Handler handler;
	private boolean collided = false;

	public Bullet(float x , float y, String direction, Handler handler) {
		this.x = x;
		this.y = y;
		this.directionOfBullet = direction;
		this.handler = handler;
		bounds = new Rectangle(13, 13, 6, 6);
	}
	public void tick() {
		Iterator<Bullet> it = handler.getWorld().getEntityManager().getPlayer().getWeapon().getBullets().iterator();
		while(it.hasNext()){
			Bullet i = it.next();
			if(i.isCollided())
				it.remove();
		}
		if(!collided) {
			if(directionOfBullet.equals("Up"))
				y-=7;
			else if(directionOfBullet.equals("Down"))
				y+=7;
			else if(directionOfBullet.equals("Left"))
				x-=7;
			else
				x+=7;
			checkifCollide();
		}
	}
	
	public void render(Graphics g) {
		if(directionOfBullet.equals("Up"))
			g.drawImage(Assets.bullets[1], (int)x , (int) y, null);
		else if(directionOfBullet.equals("Down"))
			g.drawImage(Assets.bullets[3], (int)x , (int) y, null);
		else if(directionOfBullet.equals("Left"))
			g.drawImage(Assets.bullets[0], (int)x , (int) y, null);
		else
			g.drawImage(Assets.bullets[2], (int)x , (int) y, null);
	}
	
	public void die() {
		setCollided(true);
	}
	
	public void checkifCollide() {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(handler.getWorld().getEntityManager().getPlayer()))
				continue;
			if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(handler.getGameCamera().getxOffset(),
							handler.getGameCamera().getyOffset()))) {
				e.hurt(1);
				die();
				if(e instanceof Monster) 
					if(e.getHealth() == 0)
						handler.getWorld().getEntityManager().getPlayer().
						setScore(handler.getWorld().getEntityManager().getPlayer().getScore() + 50);
				return;
			}
		}
		int[][] myTiles = handler.getWorld().getTiles();
		for(int i = 0; i<myTiles.length; i++) {
			for(int j = 0; j<myTiles.length; j++) {
				if(isSolid(myTiles[i][j]) && getCollisionBounds(handler.getGameCamera().getxOffset(),
						handler.getGameCamera().getyOffset()).intersects(getTileBounds(i, j))) {
					die();
					if(myTiles[i][j] == 2) { // ID for the wood wall
						myTiles[i][j] = 1;   // ID for the grass tile
						handler.getWorld().getEntityManager().getPlayer().setScore(handler.getWorld().getEntityManager().getPlayer().getScore() + 7);
					}
				}
			}
		}
		handler.getWorld().setTiles(myTiles);
		for(Item i : handler.getWorld().getItemManager().getItems()) {
			if(getCollisionBounds(handler.getGameCamera().getxOffset(), 
					handler.getGameCamera().getyOffset()).intersects(i.bounds)) {
				die();
				if(i.isDistructable()) {
					if(i instanceof Bomb)
						handler.getWorld().getEntityManager().getPlayer().
						setScore(handler.getWorld().getEntityManager().getPlayer().getScore() + 25);
					if(i instanceof Gift)
						handler.getWorld().getEntityManager().getPlayer().
						setScore(handler.getWorld().getEntityManager().getPlayer().getScore() - 10);
					i.setPickedUp(true);
				}
			}
		}
	}
	
	/*************************************/
	private boolean isSolid(int tileID) {
		if(tileID == 1)
			return false;
		return true;
	}
	
	private Rectangle getTileBounds(int i, int j) {
		return new Rectangle(i*32, j*32, 32, 32);
	}
	/*************************************/
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public boolean isCollided() {
		return collided;
	}
	public void setCollided(boolean collided) {
		this.collided = collided;
	}
	
}

