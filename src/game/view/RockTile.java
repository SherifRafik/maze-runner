package game.view;

import game.graphics.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.getStone(id), id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
