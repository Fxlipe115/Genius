
package genius.scores;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import genius.player.Player;
import genius.scores.Scores;

public class ScoresTest {

	@Test
	public void testScoreSize() {

		Scores scorelist = new Scores();

		for (int i = 0; i < 10; i++) {
			Player player = new Player("", i);
			scorelist.addScore(player);
			assertEquals(i + 1, scorelist.size());
		}
		assertEquals(0, scorelist.lowestScore());

		scorelist.addScore(new Player("", 100));
		assertEquals(Scores.MAX_SCORES, scorelist.size());
		assertEquals(1, scorelist.lowestScore());

		scorelist.addScore(new Player("", 200));
		assertEquals(Scores.MAX_SCORES, scorelist.size());
		assertEquals(2, scorelist.lowestScore());

	}

}
