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

}

