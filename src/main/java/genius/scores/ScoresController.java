/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.scores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author Graeff
 *
 */
public class ScoresController {
	private ScoresTableModel scoresModel;
	private ScoresPanel scoresView;

	public ScoresController() {
		Scores scores = ScoresFileUtils.loadScores(ScoresFileUtils.SCORES_FILE_NAME);
		scoresModel = new ScoresTableModel(scores);
		scoresView = new ScoresPanel();
		scoresView.addClearScoresButtonListener(clearScoresButtonListener());
		scoresView.setScoresTableModel(scoresModel);
	}

	public ScoresPanel getScoresView() {
		return scoresView;
	}

	public ScoresTableModel getScoresModel() {
		return scoresModel;
	}

	public void deleteScores() {
		int response = JOptionPane.showConfirmDialog(scoresView, "Are you sure?", "Delete all scores",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (response == JOptionPane.YES_OPTION) {
			Scores scores = scoresModel.getScores();
			scores.deleteAllScores();
			ScoresFileUtils.saveScores(ScoresFileUtils.SCORES_FILE_NAME, scores);
			scoresModel.fireTableDataChanged();
		}
	}

	private ActionListener clearScoresButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteScores();
			}
		};
	}

}
