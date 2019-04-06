package game.model;

import java.awt.image.BufferedImage;

public abstract class Gift extends Item {

	public Gift(BufferedImage texture, String name, int id) {
		super(texture, name, id);
	}
}
