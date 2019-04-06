package game.model.entity.creatures;

import game.controller.Handler;

public abstract class Monster extends Creature {

	public Monster(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		setHealth(2);
	}
}
