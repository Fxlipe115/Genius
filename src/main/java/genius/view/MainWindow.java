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

import genius.model.Settings;

public class MainWindow extends JFrame {	
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
		System.out.println(Settings.INSTANCE.getSize());
		int contentWidth = Settings.INSTANCE.getSize().getValue().width;
		int contentHeight = Settings.INSTANCE.getSize().getValue().height;
		int widthCorrection = 6;
		int heightCorrection = 30;
		int frameWidth = contentWidth + widthCorrection;
		int frameHeight = contentHeight + heightCorrection;
		
		this.setTitle("Genius");
		this.setSize(frameWidth, frameHeight);
		this.setVisible(true);
		this.setResizable(false);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
