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
import java.io.IOException;

import javax.swing.JComboBox;

import genius.types.Difficulty;
import genius.types.Mode;
import genius.types.ScreenSize;

import javax.swing.JCheckBox;


/**
 * @author Graeff
 *
 */
public class SettingsController implements ActionListener {
	
	private Settings settingsModel;
	private SettingsPanel settingsView;
	
	protected static final String SETTINGS_FILE_NAME = "settings.properties";

	public SettingsController(){
		settingsModel = Settings.INSTANCE;
		settingsModel.load(SETTINGS_FILE_NAME);
		settingsView = new SettingsPanel();
		settingsView.addSettingsController(this);
		settingsView.addApplyButtonController(this);
		settingsView.addRevertButtonController(this);
		
		refreshView();
	}
	
	public SettingsController(ActionListener parent) {
		this();
		settingsView.addBackButtonController(parent);
	}

	public SettingsPanel getSettingsView() {
		return settingsView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == settingsView.getScreenSizeComboBox()) {
			settingsModel.setSize(ScreenSize.values()[((JComboBox) e.getSource()).getSelectedIndex()]);
		}
		
		if(e.getSource() == settingsView.getGameModeComboBox()) {
			settingsModel.setMode(Mode.values()[((JComboBox) e.getSource()).getSelectedIndex()]);
		}
		
		if(e.getSource() == settingsView.getDifficultyComboBox()) {
			settingsModel.setDifficulty(Difficulty.values()[((JComboBox) e.getSource()).getSelectedIndex()]);
		}
		
		if(e.getSource() == settingsView.getMuteCheckBox()) {
			settingsModel.setSound(((JCheckBox) e.getSource()).isSelected() == false);
		}
		
		if(e.getSource() == settingsView.getApplyButton()) {
			settingsModel.persist(SETTINGS_FILE_NAME);
		}
		
		if(e.getSource() == settingsView.getRevertButton()) {
			settingsModel.load(SETTINGS_FILE_NAME);
			refreshView();
		}
	}
	
	private void refreshView() {
		settingsView.setScreenSizeComboBoxIndex(settingsModel.getSize().ordinal());
		settingsView.setGameModeComboBoxIndex(settingsModel.getMode().ordinal());
		settingsView.setDifficultyComboBoxIndex(settingsModel.getDifficulty().ordinal());
		settingsView.setMuteCheckBoxState(!settingsModel.hasSound());
	}

}

