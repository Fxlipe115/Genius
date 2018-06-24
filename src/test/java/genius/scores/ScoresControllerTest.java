package genius.scores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import genius.player.Player;
import genius.scores.ScoresController;

public class ScoresControllerTest {
	@Test
	public void testSaveLoad() {
		ScoresController scSave = new ScoresController();
		scSave.deleteScores(false);
		scSave.addScore(new Player("a", 1));
		scSave.addScore(new Player("b", 2));
		scSave.addScore(new Player("c", 3));
		scSave.addScore(new Player("d", 4));
		scSave.addScore(new Player("e", 5));
		
		scSave.saveScores();
		
		ScoresController scLoad = new ScoresController();
		scLoad.loadScores();
		
		Scores savedScores = scSave.getScoresModel().getScores();
		Scores loadedScores = scLoad.getScoresModel().getScores();
		
		assertEquals(savedScores.size(), loadedScores.size());
		
		for(int i = 0; i < savedScores.size(); i++) {
			assertTrue(savedScores.getPlayerAt(i).getName().equals(loadedScores.getPlayerAt(i).getName()));
			assertEquals(savedScores.getPlayerAt(i).getScore(), loadedScores.getPlayerAt(i).getScore());
		}
	}
}
