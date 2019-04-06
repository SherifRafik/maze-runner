package game.model.observer;

import java.awt.Graphics;

public abstract class Observer {

	protected Subject subject;
	public abstract void update(Graphics g);
}
