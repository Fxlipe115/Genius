/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.settings;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import genius.types.Difficulty;
import genius.types.Mode;
import genius.types.ScreenSize;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel implements Observer {

	private JComboBox screenSizeComboBox = new JComboBox(ScreenSize.values());
	private JComboBox gameModeComboBox = new JComboBox(Mode.values());
	private JComboBox difficultyComboBox = new JComboBox(Difficulty.values());
	private JCheckBox muteCheckBox = new JCheckBox("");
	private JButton backButton = new JButton("Back");
	private JButton applyButton = new JButton("Apply");
	private JButton revertButton = new JButton("Revert");

	public SettingsPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblScreenSize = new JLabel("Screen size");
		springLayout.putConstraint(SpringLayout.NORTH, lblScreenSize, 30, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblScreenSize, 30, SpringLayout.WEST, this);
		lblScreenSize.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		add(lblScreenSize);
		
		springLayout.putConstraint(SpringLayout.WEST, screenSizeComboBox, 25, SpringLayout.EAST, lblScreenSize);
		springLayout.putConstraint(SpringLayout.SOUTH, screenSizeComboBox, 0, SpringLayout.SOUTH, lblScreenSize);
		springLayout.putConstraint(SpringLayout.EAST, screenSizeComboBox, 200, SpringLayout.WEST, lblScreenSize);
		add(screenSizeComboBox);
		
		JLabel lblMode = new JLabel("Game mode");
		springLayout.putConstraint(SpringLayout.NORTH, lblMode, 35, SpringLayout.SOUTH, lblScreenSize);
		springLayout.putConstraint(SpringLayout.EAST, lblMode, 0, SpringLayout.EAST, lblScreenSize);
		add(lblMode);
		
		springLayout.putConstraint(SpringLayout.WEST, gameModeComboBox, 0, SpringLayout.WEST, screenSizeComboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, gameModeComboBox, 0, SpringLayout.SOUTH, lblMode);
		springLayout.putConstraint(SpringLayout.EAST, gameModeComboBox, 200, SpringLayout.WEST, lblMode);
		add(gameModeComboBox);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		springLayout.putConstraint(SpringLayout.NORTH, lblDifficulty, 35, SpringLayout.SOUTH, lblMode);
		springLayout.putConstraint(SpringLayout.EAST, lblDifficulty, 0, SpringLayout.EAST, lblScreenSize);
		add(lblDifficulty);
		
		springLayout.putConstraint(SpringLayout.WEST, difficultyComboBox, 25, SpringLayout.EAST, lblDifficulty);
		springLayout.putConstraint(SpringLayout.SOUTH, difficultyComboBox, 0, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.EAST, difficultyComboBox, 200, SpringLayout.WEST, lblScreenSize);
		add(difficultyComboBox);
		
		JLabel lblMute = new JLabel("Mute");
		springLayout.putConstraint(SpringLayout.NORTH, lblMute, 35, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.EAST, lblMute, 0, SpringLayout.EAST, lblScreenSize);
		add(lblMute);
		
		
		springLayout.putConstraint(SpringLayout.WEST, muteCheckBox, 25, SpringLayout.EAST, lblMute);
		springLayout.putConstraint(SpringLayout.SOUTH, muteCheckBox, 0, SpringLayout.SOUTH, lblMute);
		add(muteCheckBox);

		springLayout.putConstraint(SpringLayout.SOUTH, backButton, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, backButton, -10, SpringLayout.EAST, this);
		add(backButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, applyButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.EAST, applyButton, -6, SpringLayout.WEST, backButton);
		add(applyButton);
		
		springLayout.putConstraint(SpringLayout.WEST, revertButton, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, revertButton, 0, SpringLayout.SOUTH, backButton);
		add(revertButton);
	}

	public void addSettingsController(ActionListener controller){
		screenSizeComboBox.addActionListener(controller);
		gameModeComboBox.addActionListener(controller);
		difficultyComboBox.addActionListener(controller);
		muteCheckBox.addActionListener(controller);
	}
	
	public void addBackButtonController(ActionListener controller) {
		backButton.addActionListener(controller);
	}
	
	public void addApplyButtonController(ActionListener controller) {
		applyButton.addActionListener(controller);
	}
	
	public void addRevertButtonController(ActionListener controller) {
		revertButton.addActionListener(controller);
	}
	
	public void setScreenSizeComboBoxIndex(int index) {
		screenSizeComboBox.setSelectedIndex(index);
	}
	
	public void setGameModeComboBoxIndex(int index) {
		gameModeComboBox.setSelectedIndex(index);
	}
	
	public void setDifficultyComboBoxIndex(int index) {
		difficultyComboBox.setSelectedIndex(index);
	}
	
	public void setMuteCheckBoxState(boolean state) {
		this.muteCheckBox.setSelected(state);
	}
	
	public JComboBox getScreenSizeComboBox() {
		return screenSizeComboBox;
	}

	public JComboBox getGameModeComboBox() {
		return gameModeComboBox;
	}

	public JComboBox getDifficultyComboBox() {
		return difficultyComboBox;
	}

	public JCheckBox getMuteCheckBox() {
		return muteCheckBox;
	}

	public JButton getBackButton() {
		return backButton;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}

