/*
 * Final project for the course T�cnicas de Constru��o de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Inform�tica
 *
 * Created : 14 de mai de 2018
 * Author  : Graeff
 */
package genius.settings;

import static org.junit.Assert.*;

import org.junit.Test;

import genius.settings.Settings;
import genius.types.Difficulty;
import genius.types.Mode;
import genius.types.ScreenSize;

public class SettingsTest {
	@Test
	public void instatiatingCorrectValues() {
		Settings settings = new Settings();
		assertEquals(Mode.Default, settings.getMode());
		assertEquals(Difficulty.EASY, settings.getDifficulty());
		assertEquals(false, settings.isMute());
		assertEquals(ScreenSize._640x480, settings.getSize());
	}

	@Test
	public void savingAndLoading() {
		Settings settings = new Settings();

		Difficulty dif = Difficulty.MEDIUM;
		Mode mode = Mode.Default;
		boolean sound = false;
		ScreenSize size = ScreenSize._1600x1200;
		String fileName = "settings_test.properties";

		settings.setDifficulty(dif);
		settings.setMode(mode);
		settings.setMute(sound);
		settings.setSize(size);
		SettingsFileUtils.saveSettings(fileName, settings);

		settings.setDifficulty(Difficulty.HARD);
		settings.setMute(!sound);
		settings.setSize(ScreenSize._640x480);
		assertNotEquals(dif, settings.getDifficulty());
		assertNotEquals(sound, settings.isMute());
		assertNotEquals(size, settings.getSize());

		settings = SettingsFileUtils.loadSettings(fileName);
		assertEquals(dif, settings.getDifficulty());
		assertEquals(mode, settings.getMode());
		assertEquals(sound, settings.isMute());
		assertEquals(size, settings.getSize());
	}

}
