package game.view;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static String TITLE = "The Maze Runner";
		
	private static Display singleInstance = null;
	
	public static Display getDisplay() {
		
		 if(singleInstance == null) {
			 singleInstance = new Display();
		 }
		 return singleInstance;
	}
	
	private Display(){
		frame = new JFrame(TITLE);
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);
		frame.getContentPane().add(canvas);
		frame.pack();
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public int win() {
		return JOptionPane.showOptionDialog(null, "You Win!", "Congratulations", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Play Again", "Back To Main Menu"}, // this is the array
		        "default");
	}

	public int die() {
		return JOptionPane.showOptionDialog(null, "You Lose!", "Game Over", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Play Again", "Back To Main Menu"}, // this is the array
		        "default");
	}
}
