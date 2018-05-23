/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.view;

import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameDialog extends JPanel implements java.util.Observer {
	private GeniusGUI gui;
	private JFrame frame;
	
	/**
	 * Create the dialog.
	 */
	public GameDialog() {
		gui = new GeniusGUI(445, 445);
		frame = new JFrame("Genius");
		frame.setSize(450, 475);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(gui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void addController(ActionListener controller){
		gui.addActionListener(controller);
	}
	

	public void close() {
		frame.dispose();
	}


	public GeniusGUI getGui() {
		return gui;
	}
}
