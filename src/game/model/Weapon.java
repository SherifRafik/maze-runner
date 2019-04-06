package game.model;

import java.awt.Graphics;
import java.util.LinkedList;

import game.controller.Handler;

public class Weapon {

	Handler handler;
	private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	
		
	public Weapon(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		for(Bullet b : bullets) {
			b.tick();
		}
	}
	
	public void render(Graphics g) {
		for(Bullet b : bullets) {
			b.render(g);
		}
	}
	
	public void addBullet(Bullet b) {
		bullets.add(b);
		handler.getWorld().getEntityManager().getPlayer().getInventory().updateCount();
	}

	public LinkedList<Bullet> getBullets() {
		return bullets;
	}
	

	
	
}
