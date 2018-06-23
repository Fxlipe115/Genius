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
import javax.swing.JCheckBox;


/**
 * @author Graeff
 *
 */
public class SettingsController implements ActionListener {
	
	private Settings settingsModel;
	private SettingsDialog settingsView;

	public SettingsController(){
		settingsModel = Settings.INSTANCE;
		settingsView = new SettingsDialog();
		settingsView.addSettingsController(this);
		
		settingsView.setScreenSizeComboBoxIndex(settingsModel.getSize().ordinal());
		settingsView.setGameModeComboBoxIndex(settingsModel.getMode().ordinal());
		settingsView.setDifficultyComboBoxIndex(settingsModel.getDifficulty().ordinal());
		settingsView.setMuteCheckBoxState(!settingsModel.hasSound());
	}
	
	public SettingsController(ActionListener parent) {
		this();
		settingsView.addBackButtonController(parent);
	}

	public SettingsDialog getSettingsView() {
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
			settingsModel.setSound(((JCheckBox) e.getSource()).isSelected());
		}
	}

}

