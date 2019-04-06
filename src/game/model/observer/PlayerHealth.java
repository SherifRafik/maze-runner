	package game.model.observer;

import java.awt.Color;
import java.awt.Graphics;

import game.graphics.Assets;
import game.graphics.Text;
import game.model.entity.creatures.Player;

public class PlayerHealth extends Observer {

	Player player;
	public PlayerHealth(Subject subject, Player player) {
		this.subject = subject;
		this.subject.add(this);
		this.player = player;
	}
	
	@Override
	public void update(Graphics g) {
		Text.drawString(g,"Health: " + subject.getHealth(),
				200, 470, false, Color.WHITE, Assets.font28);
	}

}
