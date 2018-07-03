/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import genius.player.Player;
import genius.scores.Scores;
import genius.scores.ScoresFileUtils;
import genius.types.Button;

public abstract class GameController implements java.awt.event.ActionListener {
	protected Game gameModel;
	protected GamePanel gameView;

	protected Player player;
	protected int sequenceIndex;
	protected int sequenceSize;

	private boolean mute;

	private SequenceAnimator animator;

	public void initialize(int width, int height, int sequenceSize, boolean mute) {
		initializeModelView(width, height);
		initializeAtributes(sequenceSize, mute);
	}

	private void initializeModelView(int width, int height) {
		gameModel = new Game();
		gameView = new GamePanel(width, height);
		gameView.addController(this);
		gameView.setVisible(true);
	}

	private void initializeAtributes(int sequenceSize, boolean mute) {
		this.sequenceSize = sequenceSize;
		this.mute = mute;
		animator = null;
		player = null;
	}

	public GamePanel getGameView() {
		return gameView;
	}

	public void begin() {
		gameModel.generateSequence(sequenceSize);
		player = new Player();
		sequenceIndex = 0;
		playSequence();
	}

	public void playSequence() {
		if (animator == null) {
			animator = new SequenceAnimator();
		}
		List<Button> sequence = gameModel.getSequence().subList(0, player.getScore() + 1);
		animator.setSequence(sequence);
		animator.play();
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
			break;

		case "Begin":
		case "Restart":
			gameView.getBeginButton().setText("Repeat");
			gameView.getGui().setEnabled(true);
			begin();
			break;

		case "Repeat":
			playSequence();
			break;
		}
	}

	public abstract void handleButtonClick(Button pressedButton);

	private class SequenceAnimator {
		private List<Button> sequence;
		private int index;
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
					gameView.showWaitMessage();
					gameView.getBeginButton().setEnabled(false);
					gameView.getExitButton().setEnabled(false);
					if (!isFinished()) {
						animator.playNext();
					} else {
						t.setRepeats(false);
						gameView.showPlayerTurnMessage();
						gameView.getBeginButton().setEnabled(true);
						gameView.getExitButton().setEnabled(true);
					}
				}
			});
			t.setRepeats(true);
			t.start();
		}

		private void playNext() {
			Button next = sequence.get(index);
			gameView.getGui().setPressedButton(next);
			if(!mute) {
				gameView.playSound(next);
			}
			index++;
		}

		private boolean isFinished() {
			return index == sequence.size();
		}
	}

	public void gameOver() {
		Scores scores = ScoresFileUtils.loadScores(ScoresFileUtils.SCORES_FILE_NAME);
		if (isHighScore(scores)) {
			String name = JOptionPane.showInputDialog(gameView, "Insert your name:", "New high score",
					JOptionPane.PLAIN_MESSAGE);
			if (name != null) {
				if (!name.isEmpty()) {
					player.setName(name);
					scores.addScore(player);
					ScoresFileUtils.saveScores(ScoresFileUtils.SCORES_FILE_NAME, scores);
				}
			}
		}
	}

	private boolean isHighScore(Scores scores) {
		return tableFull(scores) ? isBiggerThanLowestScore(scores) : isBiggerThanZero();
	}

	private boolean isBiggerThanZero() {
		return player.getScore() > 0;
	}

	private boolean isBiggerThanLowestScore(Scores scores) {
		return player.getScore() > scores.lowestScore();
	}

	private boolean tableFull(Scores scores) {
		return scores.size() == Scores.MAX_SCORES;
	}

}
