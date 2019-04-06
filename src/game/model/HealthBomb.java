package game.model;

import java.awt.image.BufferedImage;

import game.model.entity.creatures.Player;

public class HealthBomb extends Bomb {

	Player player;
	
	public HealthBomb(BufferedImage texture, String name, int id) {
		super(texture, name, id);
		setDistructable(false);
	}
	
	@Override
	public void tick(){
		player = handler.getWorld().getEntityManager().getPlayer();
		if(player.getCollisionBounds(0f, 0f).intersects(bounds)){
			pickedUp = true;
			if(!player.isArmored()) {
				player.setScore(handler.getWorld().getEntityManager().getPlayer().getScore() - 5);
				player.hurt(1);
			} else {
				player.loseArmor();
			}
		}
	}	
}
