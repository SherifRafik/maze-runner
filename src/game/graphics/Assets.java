package game.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	public static BufferedImage healthBomb, bigHealthBomb;
	public static BufferedImage armorGift, bulletsGift;
	public static BufferedImage stone0, stone5, stone6, stone7, stone8, stone9;
	public static BufferedImage woodWall, grass, stone, tree, rock , uiBackGround;

	public static BufferedImage wood;
	public static BufferedImage[] healthGift;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] killerAnim, theifAnim;
	public static BufferedImage[] btn_start , btn_exit , btn_help , btn_load , bullets , playerHealth;
	public static BufferedImage[] monster_down, monster_up, monster_left, monster_right;
	public static BufferedImage inventoryScreen;

	public static void init(){
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 16);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		wood = sheet.crop(width, height, width, height);
				
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);
		player_up[0] = sheet.crop(width * 6, 0, width, height);
		player_up[1] = sheet.crop(width * 7, 0, width, height);
		player_right[0] = sheet.crop(width * 4, height, width, height);
		player_right[1] = sheet.crop(width * 5, height, width, height);
		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);
		
		monster_down = new BufferedImage[2];
		monster_up = new BufferedImage[2];
		monster_left = new BufferedImage[2];
		monster_right = new BufferedImage[2];
		
		monster_down[0] = sheet.crop(width * 4, height * 2, width, height);
		monster_down[1] = sheet.crop(width * 5, height * 2, width, height);
		monster_up[0] = sheet.crop(width * 6, height * 2, width, height);
		monster_up[1] = sheet.crop(width * 7, height * 2, width, height);
		monster_right[0] = sheet.crop(width * 4, height * 3, width, height);
		monster_right[1] = sheet.crop(width * 5, height * 3, width, height);
		monster_left[0] = sheet.crop(width * 6, height * 3, width, height);
		monster_left[1] = sheet.crop(width * 7, height * 3, width, height);

		killerAnim = new BufferedImage[9];
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_0.png"));
		killerAnim[0] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_1.png"));
		killerAnim[1] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_2.png"));
		killerAnim[2] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_3.png"));
		killerAnim[3] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_4.png"));
		killerAnim[4] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_5.png"));
		killerAnim[5] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_6.png"));
		killerAnim[6] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_7.png"));
		killerAnim[7] = sheet.crop(0, 0, 96, 100);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_bossAttack_8.png"));
		killerAnim[8] = sheet.crop(0, 0, 96, 100);

		theifAnim = new BufferedImage[4];
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_player_0.png"));
		theifAnim[0] = sheet.crop(0, 0, 60, 80);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_player_1.png"));
		theifAnim[1] = sheet.crop(0, 0, 60, 80);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_player_2.png"));
		theifAnim[2] = sheet.crop(0, 0, 60, 80);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_player_3.png"));
		theifAnim[3] = sheet.crop(0, 0, 60, 80);
		
		healthGift = new BufferedImage[6];
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_health_0.png"));
		healthGift[0] = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_health_1.png"));
		healthGift[1] = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_health_2.png"));
		healthGift[2] = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_health_3.png"));
		healthGift[3] = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_health_4.png"));
		healthGift[4] = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spr_health_5.png"));
		healthGift[5] = sheet.crop(0, 0, width, height);
		
		// grass = sheet.crop(width * 2, 0, width, height);
		// dirt = sheet.crop(width, 0, width, height);
		// stone = sheet.crop(width * 3, 0, width, height);
		// tree = sheet.crop(0, 0, width, height * 2);
		// rock = sheet.crop(0, height * 2, width, height);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheild1.png"));
		armorGift = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Fireball1.png"));
		bulletsGift = sheet.crop(0, 0, width, height);

		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/woodWall.png"));
		woodWall = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/bg_metal.png"));
		grass = sheet.crop(0, 0, 64, 64);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/dynamite1.png"));
		healthBomb = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/HealthBomb1.png"));
		bigHealthBomb = sheet.crop(0, 0, width, height);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone1.png"));
		stone = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone0.png"));
		stone0 = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone5.png"));
		stone5 = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone6.png"));
		stone6 = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone7.png"));
		stone7 = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone8.png"));
		stone8 = sheet.crop(0, 0, width, height);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/stone9.png"));
		stone9 = sheet.crop(0, 0, width, height);

		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/background.png"));
		uiBackGround = sheet.crop(0, 0, 640, 480);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/menu.png"));
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(0, 0, 185, 80);
		btn_start[1] = sheet.crop(0, 80, 185, 80);
		btn_load = new BufferedImage[2];
		btn_load[0] = sheet.crop(0, 80 * 2 , 185, 80);
		btn_load[1] = sheet.crop(0, 80 * 3 , 185, 80);
		btn_help = new BufferedImage[2];
		btn_help[0] = sheet.crop(0, 80 * 4 , 185, 80);
		btn_help[1] = sheet.crop(0, 80 * 5 , 185, 80);
		btn_exit = new BufferedImage[2];
		btn_exit[0] = sheet.crop(0, 80 * 6 , 185, 80);
		btn_exit[1] = sheet.crop(0, 80 * 7 , 185, 80);
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/bullets.png"));
		bullets = new BufferedImage[4];
		bullets[0] = sheet.crop(0, 0 , width, height); // left
		bullets[1] = sheet.crop(width, 0 , width, height); // up
		bullets[2] = sheet.crop(width * 2 , 0 , width, height); //right
		bullets[3] = sheet.crop(width * 3, 0 , width, height); // down
		



	}
	
	public static BufferedImage getStone(int id) {
		return stone;
		/*
		switch(id) {
		case 0:
			return stone0;
		case 5:
			return stone5;
		case 6:
			return stone6;
		case 7:
			return stone7;
		case 8:
			return stone8;
		default:
			return stone9;
		}
		//*/
	}
}
