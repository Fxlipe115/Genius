/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import org.jfugue.theory.Note;

import genius.player.Player;
import genius.settings.Settings;
import genius.types.Button;




/**
 * @author Graeff
 *
 */
public abstract class GameController implements java.awt.event.ActionListener {
	protected Game gameModel;
	protected GamePanel gameView;
	
	protected Player score;
	protected int sequenceIndex;
	protected int difficulty;
	
	private boolean hasSound;
	private int width;
	private int height;
	
	private SequenceAnimator animator;
	private SoundPlayer soundPlayer;
	
	public GameController() {
		width = Settings.INSTANCE.getSize().getValue().width;
		height = Settings.INSTANCE.getSize().getValue().height;
		difficulty = Settings.INSTANCE.getDifficulty().getValue();
		hasSound = Settings.INSTANCE.hasSound();

		gameModel = new Game();
		gameView = new GamePanel(width, height);
		gameModel.addObserver(gameView);
		gameView.addController(this);
		gameView.setVisible(true);
		animator = null;
		score = null;
		soundPlayer = null;
	}

	public GamePanel getGameView() {
		return gameView;
	}

	public void begin() {
		gameModel.generateSequence(difficulty);
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
		switch (e.getActionCommand()) {
		case "click":
			Button pressedButton = Button.values()[e.getModifiers()];
			handleButtonClick(pressedButton);
			break;
		
		case "wait":
			gameView.getGui().setPressedButton(null);
			gameView.getGui().setEnabled(true);
			gameView.getBeginButton().setEnabled(true);
			break;

		case "Begin":
			gameView.getBeginButton().setText("Repeat");
			gameView.getGui().setEnabled(true);
			begin();
			break;

		case "Repeat":
			playSequence();
			break;

		case "Exit":
			// exit
			break;
		}
	}

	public abstract void handleButtonClick(Button pressedButton);

	protected void playSound(Button pressedButtonColor) {
		if(soundPlayer == null) {
			soundPlayer = new SoundPlayer();
		}
		soundPlayer.playSound(pressedButtonColor);
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
			playSound(next);
			index++;
		}
		
		private boolean isFinished() {
			return index == sequence.size();
		}
	}
	
	private class SoundPlayer {

		private final Note GREEN_BUTTON_NOTE = new Note("E4i");
		private final Note BLUE_BUTTON_NOTE = new Note("Ei");
		private final Note RED_BUTTON_NOTE = new Note("Ai");
		private final Note YELLOW_BUTTON_NOTE = new Note("C#i");
		
		private org.jfugue.player.Player player = new org.jfugue.player.Player();

		public void playSound(Button pressedButtonColor) {
			final Note note = getNote(pressedButtonColor);
			if(note != null) {
				new Thread(new Runnable() {
				     public void run() {
				    	 if(hasSound) {
				    		 player.play(note);
				    	 }
				     }
				}).start();
			}
		}

		private Note getNote(Button pressedButtonColor) {
			switch (pressedButtonColor) {			
			case GREEN:
				return GREEN_BUTTON_NOTE;
			case BLUE:
				return BLUE_BUTTON_NOTE;
			case RED:
				return RED_BUTTON_NOTE;
			case YELLOW:
				return YELLOW_BUTTON_NOTE;
			default:
				return null;
			}
		}
	}

}

