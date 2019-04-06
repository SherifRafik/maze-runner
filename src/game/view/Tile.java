package game.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(2);
	public static Tile grassTile = new GrassTile(1);
	public static Tile stone0Tile = new RockTile(0);
	public static Tile stone5Tile = new RockTile(5);
	public static Tile stone6Tile = new RockTile(6);
	public static Tile stone7Tile = new RockTile(7);
	public static Tile stone8Tile = new RockTile(8);
	public static Tile stone9Tile = new RockTile(9);
	
	//CLASS
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}

	public boolean isBreakable(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
