
package genius.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;

public class TestScores {
	
	
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
		
		
		assertEquals(10,scorelist.getScores().size() );
		
		
	}





}



