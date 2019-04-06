package game.model;

public class WearingArmor extends ArmorDecorator {
	
	public WearingArmor(Armor armor) {
		
		super(armor);
		armor.putArmor();
	}
}
