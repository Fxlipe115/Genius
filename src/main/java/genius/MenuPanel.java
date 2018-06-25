package genius;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

	private JButton btnNewGame;
	private JButton btnScores;
	private JButton btnSettings;
	private JButton btnExit;
	private JLabel lblGeniusIcon;

	public MenuPanel() {
		setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(68, 48, 95, 23);
		add(btnNewGame);
		
		btnScores = new JButton("Scores");
		btnScores.setBounds(68, 102, 95, 23);
		add(btnScores);
		
		btnSettings = new JButton("Settings");
		btnSettings.setBounds(68, 159, 95, 23);
		add(btnSettings);
		
		lblGeniusIcon = new JLabel(new ImageIcon("/resources/genius.jpg"));
		lblGeniusIcon.setBounds(220, 49, 200, 200);
		add(lblGeniusIcon);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(68, 226, 95, 23);
		add(btnExit);
	}
	
	public void addNewGameButtonListener(ActionListener l) {
		btnNewGame.addActionListener(l);
	}
	
	public void addScoresButtonListener(ActionListener l) {
		btnScores.addActionListener(l);
	}
	
	public void addSettingsButtonListener(ActionListener l) {
		btnSettings.addActionListener(l);
	}
	
	public void addExitButtonListener(ActionListener l) {
		btnExit.addActionListener(l);
	}
}
