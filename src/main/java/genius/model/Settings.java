/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.model;

import java.awt.Dimension;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


/**
 * @author Graeff
 *
 */
public enum Settings {
	INSTANCE;

	private Difficulty difficulty;

	private Mode mode;
	
	private boolean sound;
	
	private Dimension size;
	
	private Settings() {
		difficulty = Difficulty.EASY;
		mode = Mode.Default;
		sound = true;
		size = new Dimension(600,600);
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Boolean hasSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}
	
	public void persist(String file) {
		File settingsFile = new File(file);

		try {
			FileWriter writer = new FileWriter(settingsFile);
			Properties props = new Properties();
		    
		    props.setProperty("difficulty", String.valueOf(difficulty));
		    props.setProperty("mode", String.valueOf(mode));
		    props.setProperty("sound", String.valueOf(sound));
		    props.setProperty("width", String.valueOf((int)size.getWidth()));
		    props.setProperty("height", String.valueOf((int)size.getHeight()));
		    props.store(writer, "settings");
		    
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load(String file) {
		File settingsFile = new File(file);
		 
		try {
		    FileReader reader = new FileReader(settingsFile);
		    Properties props = new Properties();
		    props.load(reader);
		 
		    try {
		    	difficulty = Difficulty.valueOf(props.getProperty("difficulty", Difficulty.EASY.toString()));
		    } catch (IllegalArgumentException e) {
				difficulty = Difficulty.EASY;
			}
		    try {
		    	mode = Mode.valueOf(props.getProperty("mode", Mode.Default.toString()));
		    } catch (IllegalArgumentException e) {
		    	mode = Mode.Default;
			}
		    sound = Boolean.parseBoolean(props.getProperty("sound", "true"));
		    size.width = Integer.parseInt(props.getProperty("width", "600"));
		    size.height = Integer.parseInt(props.getProperty("height", "600"));

		    reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

