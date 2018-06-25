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

	private JComboBox screenSizeComboBox;
	private JComboBox gameModeComboBox;
	private JComboBox difficultyComboBox;
	private JCheckBox muteCheckBox;
	private JButton backButton;
	private JButton applyButton;
	private JButton revertButton;

	public SettingsPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblScreenSize = new JLabel("Screen size");
		springLayout.putConstraint(SpringLayout.NORTH, lblScreenSize, 30, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblScreenSize, 30, SpringLayout.WEST, this);
		lblScreenSize.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		add(lblScreenSize);

		screenSizeComboBox = new JComboBox(ScreenSize.values());
		springLayout.putConstraint(SpringLayout.WEST, screenSizeComboBox, 25, SpringLayout.EAST, lblScreenSize);
		springLayout.putConstraint(SpringLayout.SOUTH, screenSizeComboBox, 0, SpringLayout.SOUTH, lblScreenSize);
		springLayout.putConstraint(SpringLayout.EAST, screenSizeComboBox, 200, SpringLayout.WEST, lblScreenSize);
		add(screenSizeComboBox);

		JLabel lblMode = new JLabel("Game mode");
		springLayout.putConstraint(SpringLayout.NORTH, lblMode, 35, SpringLayout.SOUTH, lblScreenSize);
		springLayout.putConstraint(SpringLayout.EAST, lblMode, 0, SpringLayout.EAST, lblScreenSize);
		add(lblMode);

		gameModeComboBox = new JComboBox(Mode.values());
		springLayout.putConstraint(SpringLayout.WEST, gameModeComboBox, 0, SpringLayout.WEST, screenSizeComboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, gameModeComboBox, 0, SpringLayout.SOUTH, lblMode);
		springLayout.putConstraint(SpringLayout.EAST, gameModeComboBox, 200, SpringLayout.WEST, lblMode);
		add(gameModeComboBox);

		JLabel lblDifficulty = new JLabel("Difficulty");
		springLayout.putConstraint(SpringLayout.NORTH, lblDifficulty, 35, SpringLayout.SOUTH, lblMode);
		springLayout.putConstraint(SpringLayout.EAST, lblDifficulty, 0, SpringLayout.EAST, lblScreenSize);
		add(lblDifficulty);

		difficultyComboBox = new JComboBox(Difficulty.values());
		springLayout.putConstraint(SpringLayout.WEST, difficultyComboBox, 25, SpringLayout.EAST, lblDifficulty);
		springLayout.putConstraint(SpringLayout.SOUTH, difficultyComboBox, 0, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.EAST, difficultyComboBox, 200, SpringLayout.WEST, lblScreenSize);
		add(difficultyComboBox);

		JLabel lblMute = new JLabel("Mute");
		springLayout.putConstraint(SpringLayout.NORTH, lblMute, 35, SpringLayout.SOUTH, lblDifficulty);
		springLayout.putConstraint(SpringLayout.EAST, lblMute, 0, SpringLayout.EAST, lblScreenSize);
		add(lblMute);

		muteCheckBox = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.WEST, muteCheckBox, 25, SpringLayout.EAST, lblMute);
		springLayout.putConstraint(SpringLayout.SOUTH, muteCheckBox, 0, SpringLayout.SOUTH, lblMute);
		add(muteCheckBox);

		backButton = new JButton("Back");
		springLayout.putConstraint(SpringLayout.SOUTH, backButton, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, backButton, -10, SpringLayout.EAST, this);
		add(backButton);

		applyButton = new JButton("Apply");
		springLayout.putConstraint(SpringLayout.NORTH, applyButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.EAST, applyButton, -6, SpringLayout.WEST, backButton);
		add(applyButton);

		revertButton = new JButton("Revert");
		springLayout.putConstraint(SpringLayout.WEST, revertButton, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, revertButton, 0, SpringLayout.SOUTH, backButton);
		add(revertButton);
	}

	public void addScreenSizeComboBoxController(ActionListener controller) {
		screenSizeComboBox.addActionListener(controller);
	}

	public void addGameModeComboBoxController(ActionListener controller) {
		gameModeComboBox.addActionListener(controller);
	}

	public void addDifficultyComboBoxController(ActionListener controller) {
		difficultyComboBox.addActionListener(controller);
	}

	public void addMuteCheckBoxController(ActionListener controller) {
		muteCheckBox.addActionListener(controller);
	}

	public void addBackButtonListener(ActionListener controller) {
		backButton.addActionListener(controller);
	}

	public void addApplyButtonController(ActionListener controller) {
		applyButton.addActionListener(controller);
	}

	public void addRevertButtonController(ActionListener controller) {
		revertButton.addActionListener(controller);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof Settings) {
			if (arg instanceof ScreenSize) {
				screenSizeComboBox.setSelectedItem(arg);
			} else if (arg instanceof Mode) {
				gameModeComboBox.setSelectedItem(arg);
			} else if (arg instanceof Difficulty) {
				difficultyComboBox.setSelectedItem(arg);
			} else if (arg instanceof Boolean) {
				muteCheckBox.setSelected(((Boolean) arg).booleanValue());
			}
		}
	}
}
