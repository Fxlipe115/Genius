/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.scores;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ScoresTableModel extends AbstractTableModel {
	private Scores scores;
	private static final String[] HEADER = {"#", "Name", "Score"};

	public ScoresTableModel() {
		super();
	}
	
	public ScoresTableModel(Scores scores) {
		super();
		
		this.scores = scores;
	}

	@Override
	public String getColumnName(int column) {
		return HEADER[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object value = null;
		switch (col) {
		case 0:
			value = row + 1;
			break;
		case 1:
			value = scores.getPlayerAt(row).getName();
			break;
		case 2:
			value = scores.getPlayerAt(row).getScore();
		default:
			break;
		}
		return value;
	}

	@Override
	public int getColumnCount() {
		return HEADER.length;
	}

	@Override
	public int getRowCount() {
		if(scores != null) {
			return scores.size();
		} else{
			return 0;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
		this.fireTableDataChanged();
	}
	
}
