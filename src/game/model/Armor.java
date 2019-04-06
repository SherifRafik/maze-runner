package game.model;

public class Armor implements ConcreteArmor {

	private boolean armored;
	
	public Armor() {

		setArmored(false);
	}
	
	public void putArmor() {
		
		setArmored(true);
	}
	
	@Override
	public boolean isArmored() {
	
		return armored;
	}
	
	public void setArmored(boolean armored) {
		this.armored = armored;
	}
	
	@Override
	public void sacrifice() {
		
		setArmored(false);
	}
}
