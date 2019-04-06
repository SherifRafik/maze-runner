package game.model;

import java.awt.image.BufferedImage;

import game.model.entity.creatures.Player;

public class ArmorGift extends Gift {

	Player player;
	
	public ArmorGift(BufferedImage texture, String name, int id) {
		super(texture, name, id);
	}
	
	@Override
	public void tick() {
		player = handler.getWorld().getEntityManager().getPlayer();
		if(player.getCollisionBounds(0f, 0f).intersects(bounds) && !player.isArmored()) {
			pickedUp = true;
			player.putArmor();
			player.getInventory().addItem(this);
			player.setScore(player.getScore() +25);
		}
	}
}
