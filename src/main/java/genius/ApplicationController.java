/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import genius.game.GameController;
import genius.game.GameControllerFactory;
import genius.scores.ScoresController;
import genius.settings.Settings;
import genius.settings.SettingsController;
import genius.settings.SettingsFileUtils;
import genius.MainWindow;
import genius.MenuPanel;

public class ApplicationController {
	private MainWindow mainWindow;

	public void initApplication() {
		Settings settings = SettingsFileUtils.loadSettings(SettingsFileUtils.SETTINGS_FILE_NAME);
		int width = settings.getSize().getValue().width;
		int height = settings.getSize().getValue().height;
		mainWindow = new MainWindow(width, height);
		openMenu();
	}

	private void openMenu() {
		MenuPanel menuPanel = new MenuPanel();
		menuPanel.addNewGameButtonListener(newGameButtonListener());
		menuPanel.addScoresButtonListener(scoresButtonListener());
		menuPanel.addSettingsButtonListener(optionsButtonListener());
		menuPanel.addExitButtonListener(exitButtonListener());
		setMainWindowContentPane(menuPanel);
	}

	private ActionListener newGameButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initGame();
			}
		};
	}

	private ActionListener scoresButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openScores();
			}
		};
	}

	private ActionListener optionsButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openSettings();
			}
		};
	}

	private ActionListener exitButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		};
	}

	private void initGame() {
		Settings settings = SettingsFileUtils.loadSettings(SettingsFileUtils.SETTINGS_FILE_NAME);
		int width = settings.getSize().getValue().width;
		int height = settings.getSize().getValue().height;
		int sequenceSize = settings.getDifficulty().getValue();
		boolean mute = settings.isMute();
		GameController gameController = GameControllerFactory.create(settings.getMode());
		gameController.initialize(width, height, sequenceSize, mute);
		gameController.getGameView().addExitButtonListener(backButtonListener());
		setMainWindowContentPane(gameController.getGameView());
	}

	private void openSettings() {
		SettingsController settingsController = new SettingsController();
		settingsController.getSettingsView().addBackButtonListener(backButtonListener());
		setMainWindowContentPane(settingsController.getSettingsView());
	}

	private void openScores() {
		ScoresController scoresController = new ScoresController();
		scoresController.getScoresView().addBackButtonListener(backButtonListener());
		setMainWindowContentPane(scoresController.getScoresView());
	}

	private ActionListener backButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openMenu();
			}
		};
	}

	private void setMainWindowContentPane(Container container) {
		mainWindow.setContentPane(container);
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	private void close() {
		mainWindow.dispose();
	}

}
