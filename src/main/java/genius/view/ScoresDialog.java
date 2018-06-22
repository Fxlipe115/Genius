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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class ScoresDialog extends JPanel {
	private JTable table;
	private JButton btnClearScores;
	private JButton btnBack;

	public ScoresDialog() {
		setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 450, 277);
		add(scrollPane);

		btnClearScores = new JButton("Clean scores");
		btnClearScores.setBounds(0, 277, 93, 23);
		add(btnClearScores);

		btnBack = new JButton("Back");
		btnBack.setBounds(361, 277, 89, 23);
		add(btnBack);

		this.getRootPane().setDefaultButton(btnBack);
	}

	public void addClearScoresButtonListener(ActionListener l) {
		btnClearScores.addActionListener(l);
	}

	public void addBackButtonListener(ActionListener l) {
		btnBack.addActionListener(l);
	}

	public void setScoresTableModel(TableModel dataModel) {
		table.setModel(dataModel);
	}

}
