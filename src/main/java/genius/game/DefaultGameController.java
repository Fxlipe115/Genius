/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.game;

import genius.types.Button;

public class DefaultGameController extends GameController {

	@Override
	public void handleButtonClick(Button pressedButton) {
		gameView.getGui().setPressedButton(pressedButton);
		gameView.playSound(pressedButton);

		if (gameModel.getSequence().get(sequenceIndex) == pressedButton) {
			if (sequenceIndex < player.getScore()) {
				sequenceIndex++;
			} else { // hit a full sequence
				player.incrementScore();
				sequenceIndex = 0;
				if (player.getScore() == sequenceSize) {
					gameView.showWinMessage();
					gameOver();
				} else {
					playSequence();
					gameView.setScore(player.getScore());
				}
			}
		} else {
			gameView.showLoseMessage();
			gameOver();
		}
	}

}
