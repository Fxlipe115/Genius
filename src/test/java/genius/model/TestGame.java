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

import org.junit.Test;


/**
 * @author Graeff
 *
 */
public class TestGame {
	@Test
	public void enumSameAsInt() {
		assertEquals(Button.RED, Button.values()[0]);
	}
}
