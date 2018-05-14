/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 11, 2018
 * Author  : 
 */
package genius.controller;

import genius.view.MainWindow;

/**
 * @author Graeff
 *
 */
public class ApplicationController {
	private MainWindow mainWindow; 
	
	/**
	 * 
	 */
	private GameController gameController;
	
	/**
	 * 
	 */
	private SettingsController settingsController;
	
	/**
	 * 
	 */
	private ScoresController scoresController;

	
	/**
	 * 
	 */
	public ApplicationController(){
		
	}

	
	/**
	 * 
	 */
	public void initApplication() {
		mainWindow = new MainWindow();
	}

	
	/**
	 * 
	 */
	public void initGame() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void openSettings() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void openScores() {
		// TODO implement me
	}

}

