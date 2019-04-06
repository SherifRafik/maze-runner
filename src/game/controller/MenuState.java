package game.controller;

import java.awt.Graphics;

import game.graphics.Assets;
import game.ui.ClickListener;
import game.ui.UIBackGround;
import game.ui.UIImageButton;
import game.ui.UIManager;
import game.utils.TimeCounter;


public class MenuState extends State {

	private UIManager uiManager;
	private TimeCounter timeCounter = new TimeCounter();
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIBackGround(0, 0, 640, 480, Assets.uiBackGround));

		uiManager.addObject(new UIImageButton(260, 150, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				TimeCounter.counter = 0;
				timeCounter.runTimer();
			}
		}));
		uiManager.addObject(new UIImageButton(260, 225, 128, 64, Assets.btn_load, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				System.exit(1);
			}
		}));
		uiManager.addObject(new UIImageButton(260, 300, 128, 64, Assets.btn_help, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				System.exit(1);

			}
		}));
		uiManager.addObject(new UIImageButton(260, 375, 128, 64, Assets.btn_exit, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				System.exit(1);
			}
		}));

	}

	@Override
	public void tick() {
		uiManager.tick();
		
		// Temporarily just go directly to the GameState, skip the menu state!
		/*handler.getMouseManager().setUIManager(null);
		State.setState(handler.getGame().gameState);*/
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	public TimeCounter getTimeCounter() {
		return timeCounter;
	}
	
	

}
