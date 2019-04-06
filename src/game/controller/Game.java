package game.controller;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import game.graphics.Assets;
import game.graphics.GameCamera;
import game.input.KeyManager;
import game.input.MouseManager;
import game.utils.Musicplayer;
import game.utils.TimeCounter;
import game.view.Display;


public class Game implements Runnable {

	private Display display;
	private int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	//Music player
	Musicplayer musicplayer = new Musicplayer("music.wav");
	

	public Game(int width, int height){
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init(){
		display = Display.getDisplay();
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		musicplayer.run();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public void setGameCamera(GameCamera gameCamera) {
		this.gameCamera = gameCamera;
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void newGame() {
		gameState = new GameState(handler);
		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);
		State.setState(gameState);
		TimeCounter.counter = 0;
	}

	private void newMenu() {
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);
		State.setState(menuState);
	}

	public void win() {
		int response = display.win();
		handler = new Handler(this);
		if(response == JOptionPane.OK_OPTION) {
			newGame();
		} else {
			newMenu();
		}
	}

	public void die() {
		int response = display.die();
		handler = new Handler(this);
		if(response == JOptionPane.OK_OPTION) {
			newGame();
		} else {
			newMenu();
		}
	}

	public State getGameState() {
		return gameState;
	}
	
	public State getMenuState() {
		return menuState;
	}

	
}
