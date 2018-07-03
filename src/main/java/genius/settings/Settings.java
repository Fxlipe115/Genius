/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.settings;

import java.io.Serializable;
import java.util.Observable;

import genius.types.Difficulty;
import genius.types.Mode;
import genius.types.ScreenSize;

/**
 * @author Graeff
 *
 */
public class Settings extends Observable implements Serializable {
	private static final long serialVersionUID = -9047313381641835943L;
	private Difficulty difficulty;
	private Mode mode;
	private boolean mute;
	private ScreenSize size;

	public Settings() {
		setDifficulty(Difficulty.EASY);
		setMode(Mode.Default);
		setMute(false);
		setSize(ScreenSize._640x480);
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
		notifyObservers(difficulty);
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
		notifyObservers(mode);
	}

	public Boolean isMute() {
		return mute;
	}

	public void setMute(boolean isMute) {
		this.mute = isMute;
		notifyObservers(Boolean.valueOf(isMute));
	}

	public ScreenSize getSize() {
		return size;
	}

	public void setSize(ScreenSize size) {
		this.size = size;
		notifyObservers(size);
	}

	@Override
	public void notifyObservers() {
		setChanged();
		notifyObservers(difficulty);
		setChanged();
		notifyObservers(mode);
		setChanged();
		notifyObservers(Boolean.valueOf(mute));
		setChanged();
		notifyObservers(size);
	}
}
