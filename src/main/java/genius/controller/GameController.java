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
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import genius.model.Button;
import genius.model.Game;
import genius.model.Player;


/**
 * @author Graeff
 *
 */
public class GameController implements java.awt.event.ActionListener {
	private Game gameModel;
	private GameDialog gameView;
	
	private Player score;
	private int sequenceIndex;
	private SequenceAnimator animator;
	
	private static final int DIFFICULTY = 10;

	
	public GameController(int width, int height){
		gameModel = new Game();
		gameView = new GameDialog(width, height);
		gameModel.addObserver(gameView);
		gameView.addController(this);
		gameView.setVisible(true);
		animator = null;
		score = null;
	}

	public GameDialog getGameView() {
		return gameView;
	}

	public void begin() {
		gameModel.generateSequence(DIFFICULTY);
		score = new Player();
		sequenceIndex = 0;
		playSequence();
	}
	
	public void playSequence() {
		if(animator == null) {
			animator = new SequenceAnimator();
		}
		List<Button> sequence = gameModel.getSequence().subList(0, score.getScore()+1);
		animator.setSequence (sequence);
		animator.play();
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
				if(sequenceIndex < score.getScore()) {
					sequenceIndex++;
				} else { // hit a full sequence
					score.incrementScore();;
					sequenceIndex = 0;
					if(score.getScore() == DIFFICULTY) {
						gameView.showWinMessage();
					} else {
						playSequence();
						gameView.setScore(score.getScore());
					}
				}
			} else {
				gameView.showLoseMessage();
			}
		}
		
		
		if(e.getActionCommand() == "wait") {
			gameView.getGui().setPressedButton(null);
			gameView.getGui().setEnabled(true);
			gameView.getBeginButton().setEnabled(true);
		}
		
		if(e.getActionCommand() == "Begin") {
			gameView.getBeginButton().setText("Repeat");
			gameView.getGui().setEnabled(true);
			begin();
		}
		
		if(e.getActionCommand() == "Repeat") {
			playSequence();
		}
		
		if(e.getActionCommand() == "Exit") {
			// exit
		}
	}

	
	
	private class SequenceAnimator {
		private List<Button> sequence;
		private int  index;
		private Timer t;
		
		public SequenceAnimator() {
			this.sequence = null;
			this.index = -1;
		}
		
		public void setSequence(List<Button> sequence) {
			this.sequence = sequence;
			this.index = 0;
		}
		
		public void play() {
			t = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!isFinished()) {
						animator.playNext();
					} else {
						t.setRepeats(false);
					}
				}
			});
			t.setRepeats(true);
			t.start();
		}

		private void playNext() {
			Button next = sequence.get(index);
			gameView.getGui().setEnabled(false);
			gameView.getBeginButton().setEnabled(false);
			gameView.getGui().setPressedButton(next);
			index++;
		}
		
		private boolean isFinished() {
			return index == sequence.size();
		}
	}

}

