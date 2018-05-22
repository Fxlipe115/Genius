/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import genius.model.Button;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class GameDialog extends JPanel implements java.util.Observer {
	private ButtonView greenButton;
	private ButtonView redButton;
	private ButtonView yellowButton;
	private ButtonView blueButton;
	private GeniusGUI gui;
	private static final Color GREEN_BUTTON_COLOR = Color.GREEN;
	private static final Color RED_BUTTON_COLOR = Color.RED;
	private static final Color YELLOW_BUTTON_COLOR = Color.YELLOW;
	private static final Color BLUE_BUTTON_COLOR = Color.BLUE;
	
	
	/**
	 * Create the dialog.
	 */
	public GameDialog() {
		gui = new GeniusGUI(445, 445);
		JFrame frame = new JFrame("Genius");
		frame.setSize(450, 475);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(gui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		
//		setTitle("Genius");
//		setResizable(false);
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 475);
//		getContentPane().setLayout(new MigLayout("", "[grow,fill][grow,fill]", "[grow,fill][grow,fill]"));
//		
		greenButton = new ButtonView(Button.GREEN, GREEN_BUTTON_COLOR);
//		getContentPane().add(greenButton, "cell 0 0");
//		
		redButton = new ButtonView(Button.RED, RED_BUTTON_COLOR);
//		getContentPane().add(redButton, "cell 1 0");
//		
		yellowButton = new ButtonView(Button.YELLOW, YELLOW_BUTTON_COLOR);
//		getContentPane().add(yellowButton, "cell 0 1");
//		
		blueButton = new ButtonView(Button.BLUE, BLUE_BUTTON_COLOR);
//		getContentPane().add(blueButton, "cell 1 1");

	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void addController(ActionListener controller){
//		gui.addMouseListener(controller);
		gui.addActionListener(controller);
	}
	
	public void animateButton(Button button) {
		final int delay = 750;

		gui.setPressedButton(button);
		
		long expectedtime = System.currentTimeMillis() + delay;
		while(System.currentTimeMillis() < expectedtime) {}
		
		gui.setPressedButton(null);

	}
	
//	public void animateButton(Button button) {
//		
//		switch(button) {
//		case BLUE:
//			blueButton.setEnabled(false);
//			redButton.setEnabled(false);
//			yellowButton.setEnabled(false);
//			greenButton.setEnabled(false);
//			animateButton(blueButton);
//			blueButton.setEnabled(true);
//			redButton.setEnabled(true);
//			yellowButton.setEnabled(true);
//			greenButton.setEnabled(true);
//			break;
//		case RED:
//			blueButton.setEnabled(false);
//			redButton.setEnabled(false);
//			yellowButton.setEnabled(false);
//			greenButton.setEnabled(false);
//			animateButton(redButton);
//			blueButton.setEnabled(true);
//			redButton.setEnabled(true);
//			yellowButton.setEnabled(true);
//			greenButton.setEnabled(true);
//			break;
//		case GREEN:
//			blueButton.setEnabled(false);
//			redButton.setEnabled(false);
//			yellowButton.setEnabled(false);
//			greenButton.setEnabled(false);
//			animateButton(greenButton);
//			blueButton.setEnabled(true);
//			redButton.setEnabled(true);
//			yellowButton.setEnabled(true);
//			greenButton.setEnabled(true);
//			break;
//		case YELLOW:
//			blueButton.setEnabled(false);
//			redButton.setEnabled(false);
//			yellowButton.setEnabled(false);
//			greenButton.setEnabled(false);
//			animateButton(yellowButton);
//			blueButton.setEnabled(true);
//			redButton.setEnabled(true);
//			yellowButton.setEnabled(true);
//			greenButton.setEnabled(true);
//			break;
//		}
//	}

}
