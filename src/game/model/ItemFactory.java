package game.model;

import game.graphics.Assets;

public class ItemFactory {

	public Item getItem(String name, int x, int y) {
		
		if(name.equals("Health Bomb")) {
			HealthBomb hb = new HealthBomb(Assets.healthBomb, "Health Bomb", 0);
			hb.setPosition(x, y);
			return hb;
		} else if(name.equals("Big Health Bomb")) {
			BigHealthBomb bhb = new BigHealthBomb(Assets.bigHealthBomb, "Big Health Bomb", 1);
			bhb.setPosition(x, y);
			return bhb;
		} else if(name.equals("Health Gift")) {
			HealthGift hg = new HealthGift(Assets.healthGift[0], "Health Gift", 2);
			hg.setPosition(x, y);
			return hg;
		} else if(name.equals("Armor Gift")){
			ArmorGift ag = new ArmorGift(Assets.armorGift, "Armor", 3);
			ag.setPosition(x, y);
			return ag;
		} else if(name.equals("Bullets Gift")) {
			BulletsGift bg = new BulletsGift(Assets.bulletsGift, "Bullets", 4);
			bg.setPosition(x, y);
			return bg;
		} else {
			return null;		
		}
	}
}
