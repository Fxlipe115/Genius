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

import java.io.IOException;

import org.junit.Test;

import genius.settings.Settings;
import genius.types.Difficulty;
import genius.types.Mode;
import genius.types.ScreenSize;



public class SettingsTest {
	@Test
	public void instatiatingCorrectValues(){
		Settings settings = Settings.INSTANCE;
		assertEquals(Mode.Default, settings.getMode());
		assertEquals(Difficulty.EASY, settings.getDifficulty());
		assertEquals(true, settings.hasSound());
		assertEquals(ScreenSize._640x480, settings.getSize());
	}
	
	@Test
	public void savingAndLoading() throws IOException{
		Settings settings = Settings.INSTANCE;
		
		Difficulty dif = Difficulty.MEDIUM;
		Mode mode = Mode.Default;
		boolean sound = false;
		ScreenSize size = ScreenSize._1600x1200;
		String fileName = "settings_test.properties";
		
		settings.setDifficulty(dif);
		settings.setMode(mode);
		settings.setSound(sound);
		settings.setSize(size);
		settings.persist(fileName);
		
		settings.setDifficulty(Difficulty.HARD);
		settings.setSound(!sound);
		settings.setSize(ScreenSize._640x480);
		assertNotEquals(dif, settings.getDifficulty());
		assertNotEquals(sound, settings.hasSound());
		assertNotEquals(size, settings.getSize());
		
		settings.load(fileName);
		assertEquals(dif, settings.getDifficulty());
		assertEquals(mode, settings.getMode());
		assertEquals(sound, settings.hasSound());
		assertEquals(size, settings.getSize());
	}

}
