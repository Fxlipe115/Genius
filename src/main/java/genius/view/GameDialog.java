/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.Timer;

import genius.model.Button;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class GameDialog extends JDialog implements java.util.Observer {
	private ButtonView greenButton;
	private ButtonView redButton;
	private ButtonView yellowButton;
	private ButtonView blueButton;
	private static final Color GREEN_BUTTON_COLOR = Color.GREEN;
	private static final Color RED_BUTTON_COLOR = Color.RED;
	private static final Color YELLOW_BUTTON_COLOR = Color.YELLOW;
	private static final Color BLUE_BUTTON_COLOR = Color.BLUE;
	private static final Color BUTTON_PRESSED_COLOR = Color.BLACK;
	
	
	/**
	 * Create the dialog.
	 */
	public GameDialog() {
		setTitle("Genius");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 475);
		getContentPane().setLayout(new MigLayout("", "[grow,fill][grow,fill]", "[grow,fill][grow,fill]"));
		
		greenButton = new ButtonView(Button.GREEN);
		greenButton.setBackground(GREEN_BUTTON_COLOR);
		getContentPane().add(greenButton, "cell 0 0");
		
		redButton = new ButtonView(Button.RED);
		redButton.setBackground(RED_BUTTON_COLOR);
		getContentPane().add(redButton, "cell 1 0");
		
		yellowButton = new ButtonView(Button.YELLOW);
		yellowButton.setBackground(YELLOW_BUTTON_COLOR);
		getContentPane().add(yellowButton, "cell 0 1");
		
		blueButton = new ButtonView(Button.BLUE);
		blueButton.setBackground(BLUE_BUTTON_COLOR);
		getContentPane().add(blueButton, "cell 1 1");

	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void addController(MouseListener controller){
		greenButton.addMouseListener(controller);
		blueButton.addMouseListener(controller);
		yellowButton.addMouseListener(controller);
		redButton.addMouseListener(controller);
	}
	
	public void animateButton(Canvas button) {
		final int delay = 750;

	    Color originalColor = button.getBackground();
	    button.setBackground(BUTTON_PRESSED_COLOR);
//		Timer timerBegin = new Timer(delay, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				button.setBackground(BUTTON_PRESSED_COLOR);
//			}
//        });
//        timerBegin.setRepeats(false);
//        timerBegin.start();
        
	    Timer timerEnd = new Timer(delay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button.setBackground(originalColor);	
			}
        });
        timerEnd.setRepeats(false);
        timerEnd.start();
	}
	
	public void animateButton(Button button) {
		switch(button) {
		case BLUE:
			blueButton.setEnabled(false);
			redButton.setEnabled(false);
			yellowButton.setEnabled(false);
			greenButton.setEnabled(false);
			animateButton(blueButton);
			blueButton.setEnabled(true);
			redButton.setEnabled(true);
			yellowButton.setEnabled(true);
			greenButton.setEnabled(true);
			break;
		case RED:
			blueButton.setEnabled(false);
			redButton.setEnabled(false);
			yellowButton.setEnabled(false);
			greenButton.setEnabled(false);
			animateButton(redButton);
			blueButton.setEnabled(true);
			redButton.setEnabled(true);
			yellowButton.setEnabled(true);
			greenButton.setEnabled(true);
			break;
		case GREEN:
			blueButton.setEnabled(false);
			redButton.setEnabled(false);
			yellowButton.setEnabled(false);
			greenButton.setEnabled(false);
			animateButton(greenButton);
			blueButton.setEnabled(true);
			redButton.setEnabled(true);
			yellowButton.setEnabled(true);
			greenButton.setEnabled(true);
			break;
		case YELLOW:
			blueButton.setEnabled(false);
			redButton.setEnabled(false);
			yellowButton.setEnabled(false);
			greenButton.setEnabled(false);
			animateButton(yellowButton);
			blueButton.setEnabled(true);
			redButton.setEnabled(true);
			yellowButton.setEnabled(true);
			greenButton.setEnabled(true);
			break;
		}
	}

}
