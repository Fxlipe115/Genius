/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.controller;
import genius.view.GameDialog;

import java.awt.event.ActionEvent;
import genius.model.Button;
import genius.model.Game;


/**
 * @author Graeff
 *
 */
public class GameController implements java.awt.event.ActionListener {
	private Game gameModel;
	private GameDialog gameView;
	
	private int score;
	private int sequenceIndex;
	
	private static final int DIFFICULTY = 10;

	
	public GameController(){
		gameModel = new Game();
		gameView = new GameDialog();
		gameModel.addObserver(gameView);
		gameView.addController(this);
		gameView.setVisible(true);
		begin();
	}

	public void begin() {
		gameModel.generateSequence(DIFFICULTY);
		score = 0;
		sequenceIndex = 0;
		playSequence();
	}
	
	public void playSequence() {
		for(int i = 0; i <= score; i++) {
			Button button = gameModel.getSequence().get(i);
			gameView.getGui().setPressedButton(button);
		}
	}


	public void pause() {
		// TODO implement me
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "click") {
			Button pressedButtonColor = Button.values()[e.getModifiers()];
			
			gameView.getGui().setPressedButton(pressedButtonColor);
			
			if(gameModel.getSequence().get(sequenceIndex) == pressedButtonColor) {
				if(sequenceIndex < score) {
					sequenceIndex++;
					System.out.println("Right");
				} else { // hit a full sequence
					score++;
					sequenceIndex = 0;
					playSequence();
					System.out.println("Score: " + score);
					if(score == DIFFICULTY) {
						System.out.println("You win");
							gameView.close();
					}
				}
			} else {
				System.out.println("You lose");
					gameView.close();
			}
		}
		
		if(e.getActionCommand() == "wait") {
			gameView.getGui().setPressedButton(null);
		}
		
		
	}

}

