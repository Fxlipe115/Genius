/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 11, 2018
 * Author  : Graeff 
 */
package genius.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import genius.view.MainWindow;
import genius.view.MenuPanel;

/**
 * @author Graeff
 *
 */
public class ApplicationController implements ActionListener {
	private MainWindow mainWindow;

	public void initApplication() {
		mainWindow = new MainWindow();
		openMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "New Game":
			initGame();
			break;
		case "Scores":
			openScores();
			break;
		case "Options":
			openSettings();
			break;
		case "Exit":
			close();
			break;
		case "Back":
			openMenu();
			break;
		default:
			break;
		}
	}

	private void openMenu() {
		MenuPanel menuPanel = new MenuPanel();
		menuPanel.addNewGameButtonListener(this);
		menuPanel.addScoresButtonListener(this);
		menuPanel.addOptionsButtonListener(this);
		menuPanel.addExitButtonListener(this);
		mainWindow.setContentPane(menuPanel);
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	private void initGame() {
		GameController gameController = new GameController();
		gameController.getGameView().addController(this);
		mainWindow.setContentPane(gameController.getGameView());
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	private void openSettings() {
		SettingsController settingsController = new SettingsController();
		settingsController.getSettingsView().addBackButtonController(this);
		mainWindow.setContentPane(settingsController.getSettingsView());
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	private void openScores() {
		ScoresController scoresController = new ScoresController();
		scoresController.getScoresView().addBackButtonListener(this);
		mainWindow.setContentPane(scoresController.getScoresView());
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	private void close() {
		mainWindow.dispose();
	}

}
