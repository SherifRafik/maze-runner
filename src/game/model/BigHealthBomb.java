package game.model;

import java.awt.image.BufferedImage;

import game.model.entity.creatures.Player;

public class BigHealthBomb extends Bomb {

	Player player;
	
	public BigHealthBomb(BufferedImage texture, String name, int id) {
		super(texture, name, id);
	}

	@Override
	public void tick(){
		player = handler.getWorld().getEntityManager().getPlayer();
		if(player.getCollisionBounds(0f, 0f).intersects(bounds)){
			pickedUp = true;
			if(!player.isArmored()) {
				player.setScore(handler.getWorld().getEntityManager().getPlayer().getScore() - 10);
				player.hurt(2);
			} else {
				player.loseArmor();
			}
		}
	}	
}
