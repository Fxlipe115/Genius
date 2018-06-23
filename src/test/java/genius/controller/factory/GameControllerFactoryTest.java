package genius.controller.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import genius.controller.DefaultGameController;
import genius.controller.GameController;
import genius.model.Mode;

public class GameControllerFactoryTest {

	@Test
	public void shouldCreateDefaultGameController() {
		GameController gc = GameControllerFactory.create(Mode.Default);
		
		assertTrue(gc instanceof DefaultGameController);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		GameControllerFactory.create(null);
	}

}
