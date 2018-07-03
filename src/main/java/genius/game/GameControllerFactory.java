/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.game;

import genius.types.Mode;

public class GameControllerFactory {

	public static GameController create(Mode mode) {
		if (mode != null) {
			switch (mode) {
			case Default:
				return new DefaultGameController();
			default:
				throw new IllegalArgumentException("Could not create game controller for " + mode.toString() + " mode");
			}
		} else {
			throw new IllegalArgumentException("Could not create game controller for null mode");
		}
	}

}
