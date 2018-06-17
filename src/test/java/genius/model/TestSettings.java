/*
 * Final project for the course T�cnicas de Constru��o de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Inform�tica
 *
 * Created : 14 de mai de 2018
 * Author  : Graeff
 */
package genius.model;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;



public class TestSettings {
	@Test
	public void instatiatingCorrectValues(){
		assertEquals(Mode.Default, Settings.INSTANCE.getMode());
		assertEquals(Difficulty.EASY, Settings.INSTANCE.getDifficulty());
		assertEquals(true, Settings.INSTANCE.hasSound());
		assertEquals(ScreenSize._640x480, Settings.INSTANCE.getSize());
	}
	
	@Test
	public void savingAndLoading(){
		Difficulty dif = Difficulty.MEDIUM;
		Mode mode = Mode.Default;
		boolean sound = false;
		ScreenSize size = ScreenSize._1600x1200;
		String fileName = "settings_test.properties";
		
		Settings.INSTANCE.setDifficulty(dif);
		Settings.INSTANCE.setMode(mode);
		Settings.INSTANCE.setSound(sound);
		Settings.INSTANCE.setSize(size);
		Settings.INSTANCE.persist(fileName);
		
		Settings.INSTANCE.setDifficulty(Difficulty.HARD);
		Settings.INSTANCE.setSound(!sound);
		Settings.INSTANCE.setSize(ScreenSize._640x480);
		assertNotEquals(dif, Settings.INSTANCE.getDifficulty());
		assertNotEquals(sound, Settings.INSTANCE.hasSound());
		assertNotEquals(size, Settings.INSTANCE.getSize());
		
		Settings.INSTANCE.load(fileName);
		assertEquals(dif, Settings.INSTANCE.getDifficulty());
		assertEquals(mode, Settings.INSTANCE.getMode());
		assertEquals(sound, Settings.INSTANCE.hasSound());
		assertEquals(size, Settings.INSTANCE.getSize());
	}

}
