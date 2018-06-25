/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import genius.types.Difficulty;
import genius.types.Mode;
import genius.types.ScreenSize;

import javax.swing.JCheckBox;

/**
 * @author Graeff
 *
 */
public class SettingsController {

	private Settings settingsModel;
	private SettingsPanel settingsView;

	public SettingsController() {
		settingsModel = new Settings();
		settingsView = new SettingsPanel();
		setSettingsModel(SettingsFileUtils.loadSettings(SettingsFileUtils.SETTINGS_FILE_NAME));
		settingsView.addScreenSizeComboBoxController(screenSizeComboBoxController());
		settingsView.addGameModeComboBoxController(gameModeComboBoxController());
		settingsView.addDifficultyComboBoxController(difficultyComboBoxController());
		settingsView.addMuteCheckBoxController(muteCheckBoxController());
		settingsView.addApplyButtonController(applyButtonController());
		settingsView.addRevertButtonController(revertButtonController());
	}

	public SettingsController(ActionListener parent) {
		this();
		settingsView.addBackButtonListener(parent);
	}

	public SettingsPanel getSettingsView() {
		return settingsView;
	}
	
	private void setSettingsModel(Settings settings) {
		this.settingsModel = settings;
		settingsModel.addObserver(settingsView);
		settingsModel.notifyObservers();
	}

	private ActionListener screenSizeComboBoxController() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "comboBoxChanged") {
					int index = ((JComboBox) e.getSource()).getSelectedIndex();
					ScreenSize size = ScreenSize.values()[index];
					settingsModel.setSize(size);
				}
			}
		};
	}

	private ActionListener gameModeComboBoxController() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "comboBoxChanged") {
					int index = ((JComboBox) e.getSource()).getSelectedIndex();
					Mode mode = Mode.values()[index];
					settingsModel.setMode(mode);
				}
			}
		};
	}

	private ActionListener difficultyComboBoxController() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "comboBoxChanged") {
					int index = ((JComboBox) e.getSource()).getSelectedIndex();
					Difficulty difficulty = Difficulty.values()[index];
					settingsModel.setDifficulty(difficulty);
				}
			}
		};
	}

	private ActionListener muteCheckBoxController() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean mute = ((JCheckBox) e.getSource()).isSelected();
				settingsModel.setMute(mute);
			}
		};
	}

	private ActionListener applyButtonController() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsFileUtils.saveSettings(SettingsFileUtils.SETTINGS_FILE_NAME, settingsModel);
			}
		};
	}

	private ActionListener revertButtonController() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSettingsModel(SettingsFileUtils.loadSettings(SettingsFileUtils.SETTINGS_FILE_NAME));
			}
		};
	}

}
