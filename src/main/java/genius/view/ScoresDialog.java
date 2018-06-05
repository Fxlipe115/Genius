/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : Graeff
 */
package genius.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ScoresDialog extends JPanel implements Observer{
	private JTable table;
	private JButton btnClearScores;
	
	public ScoresDialog() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		btnClearScores = new JButton("Clear scores");
		add(btnClearScores, BorderLayout.SOUTH);
		

	}
	
	
	public void addController(ActionListener controller){
		btnClearScores.addActionListener(controller);
	}
	
	

	public JTable getTable() {
		return table;
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
