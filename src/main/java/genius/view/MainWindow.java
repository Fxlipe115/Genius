/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.view;

import javax.swing.JFrame;

import genius.controller.GameController;

public class MainWindow {

	private JFrame frame;

	
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int contentWidth = 450;
		int contentHeight = 450;
		int widthCorrection = 6;
		int heightCorrection = 30;
		int frameWidth = contentWidth + widthCorrection;
		int frameHeight = contentHeight + heightCorrection;
		
		frame = new JFrame("Genius");
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.setResizable(false);
		
		GameController gc = new GameController(contentWidth, contentHeight);
		frame.add(gc.getGameView());
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
