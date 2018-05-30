/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.controller;
import genius.model.Settings;
import genius.view.SettingsDialog;


/**
 * @author Graeff
 *
 */
public class SettingsController {
	/**
	 * 
	 */
	private Settings settingsModel;

	/**
	 * 
	 */
	private SettingsDialog settingsView;


	/**
	 * 
	 */
	public SettingsController(){
		settingsModel = Settings.INSTANCE;
		settingsView = new SettingsDialog();
	}

	
	/**
	 * 
	 */
	public void setDifficulty() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void setMode() {
		// TODO implement me
	}
	
	
	/**
	 * 
	 */
	public void setVolume() {
		// TODO implement me
	}

}

