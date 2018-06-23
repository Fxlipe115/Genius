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
	private JButton btnOptions;
	private JButton btnExit;
	private JLabel lblGeniusIcon;

	public MenuPanel() {
		setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(68, 48, 89, 23);
		add(btnNewGame);
		
		btnScores = new JButton("Scores");
		btnScores.setBounds(68, 102, 89, 23);
		add(btnScores);
		
		btnOptions = new JButton("Options");
		btnOptions.setBounds(68, 159, 89, 23);
		add(btnOptions);
		
		lblGeniusIcon = new JLabel(new ImageIcon("/resources/genius.jpg"));
		lblGeniusIcon.setBounds(220, 49, 200, 200);
		add(lblGeniusIcon);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(68, 226, 89, 23);
		add(btnExit);
	}
	
	public void addNewGameButtonListener(ActionListener l) {
		btnNewGame.addActionListener(l);
	}
	
	public void addScoresButtonListener(ActionListener l) {
		btnScores.addActionListener(l);
	}
	
	public void addOptionsButtonListener(ActionListener l) {
		btnOptions.addActionListener(l);
	}
	
	public void addExitButtonListener(ActionListener l) {
		btnExit.addActionListener(l);
	}
}
