/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.game;

import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class GamePanel extends JLayeredPane {
	private GeniusButtons gui;
	private JButton beginButton;
	private JButton exitButton;
	private JLabel scoreLabel;

	/**
	 * Create the dialog.
	 */
	public GamePanel(int width, int height) {
		int buttonsWidth = 80;
		int buttonsHeight = 30;
		int scoreLabelWidth = 2 * buttonsWidth;
		int scoreLabelHeight = 30;

		this.setSize(width, height);

		this.setOpaque(true);
		this.setBackground(Color.GRAY);

		gui = new GeniusButtons(height, height);
		gui.setBounds((width - height) / 2, 0, height, height);
		gui.setEnabled(false);
		this.add(gui, DEFAULT_LAYER);

		beginButton = new JButton("Begin");
		beginButton.setBounds((width / 2) - buttonsWidth, height / 2, buttonsWidth, buttonsHeight);
		this.add(beginButton, PALETTE_LAYER);

		exitButton = new JButton("Back");
		exitButton.setBounds(width / 2, height / 2, buttonsWidth, buttonsHeight);
		this.add(exitButton, PALETTE_LAYER);

		scoreLabel = new JLabel("0");
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setFont(new Font("Sans-Serif", Font.BOLD, 32));
		scoreLabel.setForeground(Color.GREEN.brighter());
		scoreLabel.setBounds((width / 2) - (scoreLabelWidth / 2), (height / 2) - scoreLabelHeight, scoreLabelWidth,
				scoreLabelHeight);
		this.add(scoreLabel, PALETTE_LAYER);
	}

	public JButton getBeginButton() {
		return beginButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void addController(ActionListener controller) {
		gui.addActionListener(controller);
		beginButton.addActionListener(controller);
		exitButton.addActionListener(controller);
	}
	public void addExitButtonListener(ActionListener l) {
		exitButton.addActionListener(l);
	}

	public GeniusButtons getGui() {
		return gui;
	}

	public void showWinMessage() {
		scoreLabel.setText("You win");
		gameOver();
	}

	public void showLoseMessage() {
		scoreLabel.setText("You lose");
		gameOver();
	}

	private void gameOver() {
		gui.setEnabled(false);
		beginButton.setText("Restart");
	}

	public void setScore(int score) {
		scoreLabel.setText(Integer.toString(score));
	}

	public void showWaitMessage() {
		scoreLabel.setText("Wait...");
	}

	public void showPlayerTurnMessage() {
		scoreLabel.setText("Your turn");
	}
}
