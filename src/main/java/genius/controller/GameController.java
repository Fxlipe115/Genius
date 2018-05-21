/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.controller;
import genius.view.ButtonView;
import genius.view.GameDialog;

import java.awt.event.MouseEvent;

import genius.model.Button;
import genius.model.Game;


/**
 * @author Graeff
 *
 */
public class GameController implements java.awt.event.MouseListener {
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
			gameView.animateButton(gameModel.getSequence().get(i));
		}
	}
	
//	public void animateButton() {
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		})
//	}


	public void pause() {
		// TODO implement me
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		ButtonView pressedButton = (ButtonView) e.getSource();
		gameView.animateButton(pressedButton);
		Button pressedButtonColor = pressedButton.getValue();
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
					gameView.dispose();
				}
			}
		} else {
			System.out.println("You lose");
			gameView.dispose();
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}

