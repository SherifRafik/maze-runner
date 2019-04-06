package game.model;

import java.awt.image.BufferedImage;

public abstract class Bomb extends Item {

	public Bomb(BufferedImage texture, String name, int id) {
		super(texture, name, id);
		setDistructable(true);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
	}

	@Override
	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(
				handler.getGameCamera().getxOffset(), handler.getGameCamera().getyOffset()).intersects(bounds)){
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().setScore(handler.getWorld().getEntityManager().getPlayer().getScore() - 5);
			handler.getWorld().getEntityManager().getPlayer().hurt(1);
		}
	}
}
