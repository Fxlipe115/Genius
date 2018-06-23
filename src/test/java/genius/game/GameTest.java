/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : 14 de mai de 2018
 * Author  : Graeff
 */
package genius.game;

import static org.junit.Assert.*;

import org.junit.Test;

import genius.button.Button;


/**
 * @author Graeff
 *
 */
public class GameTest {
	@Test
	public void enumSameAsInt() {
		assertEquals(Button.RED, Button.values()[0]);
	}
}
