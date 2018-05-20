/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.view;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GameDialog extends JDialog {
	private Canvas greenButton;
	private Canvas redButton;
	private Canvas yellowButton;
	private Canvas blueButton;
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow,fill][grow,fill]", "[grow,fill][grow,fill]"));
		
		greenButton = new Canvas();
		greenButton.setBackground(GREEN_BUTTON_COLOR);
		greenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				greenButton.setBackground(BUTTON_PRESSED_COLOR);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				greenButton.setBackground(GREEN_BUTTON_COLOR);
			}
		});
		getContentPane().add(greenButton, "cell 0 0");
		
		redButton = new Canvas();
		redButton.setBackground(RED_BUTTON_COLOR);
		redButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				redButton.setBackground(BUTTON_PRESSED_COLOR);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				redButton.setBackground(RED_BUTTON_COLOR);
			}
		});
		getContentPane().add(redButton, "cell 1 0");
		
		yellowButton = new Canvas();
		yellowButton.setBackground(YELLOW_BUTTON_COLOR);
		yellowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				yellowButton.setBackground(BUTTON_PRESSED_COLOR);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				yellowButton.setBackground(YELLOW_BUTTON_COLOR);
			}
		});
		getContentPane().add(yellowButton, "cell 0 1");
		
		blueButton = new Canvas();
		blueButton.setBackground(BLUE_BUTTON_COLOR);
		blueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				blueButton.setBackground(BUTTON_PRESSED_COLOR);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				blueButton.setBackground(BLUE_BUTTON_COLOR);
			}
		});
		getContentPane().add(blueButton, "cell 1 1");

	}

}
