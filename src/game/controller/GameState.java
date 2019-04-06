package game.controller;

import java.awt.Color;
import java.awt.Graphics;

import game.graphics.Assets;
import game.graphics.Text;
import game.utils.TimeCounter;
import game.worlds.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		drawTime(g);
	}
		
	public void drawTime(Graphics g) {
		Text.drawString(g,"Time elapsed: " + TimeCounter.time,
				368, 470, false, Color.WHITE, Assets.font28);
	}


	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
