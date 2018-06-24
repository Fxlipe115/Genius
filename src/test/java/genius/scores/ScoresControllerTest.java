package genius.scores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import genius.player.Player;

public class ScoresControllerTest {
	@Test
	public void testSaveLoad() {
		String testScoreFile = "score_test.genius";
		
		Scores savedScores = new Scores();
		savedScores.addScore(new Player("a", 1));
		savedScores.addScore(new Player("b", 2));
		savedScores.addScore(new Player("c", 3));
		savedScores.addScore(new Player("d", 4));
		savedScores.addScore(new Player("e", 5));
		
		ScoresFileUtils.saveScores(testScoreFile, savedScores);
		
		Scores loadedScores = ScoresFileUtils.loadScores(testScoreFile);
		
		assertEquals(savedScores.size(), loadedScores.size());
		
		for(int i = 0; i < savedScores.size(); i++) {
			assertTrue(savedScores.getPlayerAt(i).getName().equals(loadedScores.getPlayerAt(i).getName()));
			assertEquals(savedScores.getPlayerAt(i).getScore(), loadedScores.getPlayerAt(i).getScore());
		}
	}
}
