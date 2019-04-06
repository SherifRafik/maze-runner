package game.utils;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Musicplayer implements Runnable {

	Clip clip;
	String filepath;
	public Musicplayer(String filepath) {
		this.filepath = filepath;
	}
	
	private void playMusic() {
		File file = new File(filepath);
		try {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
		clip = (Clip)AudioSystem.getLine(info);
		clip.open(audioInputStream);
		clip.start();
		clip.loop(-1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			@SuppressWarnings("unused")
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		playMusic();
	}
	


}
