package genius.controller.factory;

import genius.controller.DefaultGameController;
import genius.controller.GameController;
import genius.model.Mode;

public class GameControllerFactory {

	public static GameController create(Mode mode) {
		switch (mode) {
		case Default:
			return new DefaultGameController();
		default:
			throw new IllegalArgumentException("Could not create game controller for " + mode.toString() + " mode");
		}
	}
	
}
