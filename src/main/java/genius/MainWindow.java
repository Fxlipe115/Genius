/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {	
	/**
	 * Create the application.
	 */
	public MainWindow(int width, int heigth) {
		initialize(width, heigth);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int width, int height) {
		int contentWidth = width;
		int contentHeight = height;
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
