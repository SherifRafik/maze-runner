package game.model;

import java.awt.image.BufferedImage;

import game.model.entity.creatures.Player;

public class BulletsGift extends Gift {

	Player player;
	
	public BulletsGift(BufferedImage texture, String name, int id) {
		super(texture, name, id);
	}
	
	public int getCount() {
		return player.getAvailableBullets();
	}
	
	@Override
	public void tick() {
		player = handler.getWorld().getEntityManager().getPlayer();
		if(player.getCollisionBounds(0f, 0f).intersects(bounds) &&
				player.getAvailableBullets() != 6) {
			
			pickedUp = true;
			player.setAvailableBullets((player.getAvailableBullets()+2));
			player.getInventory().addItem(this);
			if(player.isEmptyMagazine())
				player.setEmptyMagazine(false);
			if(player.getAvailableBullets()>6)
				player.setAvailableBullets(6);
			handler.getWorld().getEntityManager().getPlayer().setScore(handler.getWorld().getEntityManager().getPlayer().getScore() +20);

		}
	}	
}
