
package genius.scores;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import genius.player.Player;
import genius.scores.Scores;

public class ScoresTest {
	
	
	@Test
	public void testScoreSize() {
	
		Scores scorelist = new Scores();
		
		Player jogador = new Player();
		
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		scorelist.addScore(jogador);
		
		
		assertEquals(10,scorelist.size());
		
		
	}





}



