package genius.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import genius.model.Player;

public class ScoresControllerTest {
	@Test
	public void testSaveLoad() {
		ScoresController scSave = new ScoresController();
		scSave.deleteScores();
		scSave.addScore(new Player("a", 1));
		scSave.addScore(new Player("b", 2));
		scSave.addScore(new Player("c", 3));
		scSave.addScore(new Player("d", 4));
		scSave.addScore(new Player("e", 5));
		
		scSave.saveScores();
		
		ScoresController scLoad = new ScoresController();
		scLoad.loadScores();
		
		List<Player> savedScores = scSave.getScoresModel().getScores().getScores();
		List<Player> loadedScores = scLoad.getScoresModel().getScores().getScores();
		
		assertEquals(savedScores.size(), loadedScores.size());
		
		for(int i = 0; i < savedScores.size(); i++) {
			assertTrue(savedScores.get(i).getName().equals(loadedScores.get(i).getName()));
			assertEquals(savedScores.get(i).getScore(), loadedScores.get(i).getScore());
		}
	}
}
