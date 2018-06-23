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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

import genius.player.Player;


/**
 * @author Graeff
 *
 */
public class ScoresController implements ActionListener {
	private ScoresTableModel scoresModel;
	private ScoresDialog scoresView;

	
	public ScoresController(){
		scoresView = new ScoresDialog();
		scoresModel = new ScoresTableModel();
		scoresView.addClearScoresButtonListener(this);
		scoresView.setScoresTableModel(scoresModel);
		loadScores();
	}


	public ScoresDialog getScoresView() {
		return scoresView;
	}


	public ScoresTableModel getScoresModel() {
		return scoresModel;
	}


	public void deleteScores(boolean askConfirmation) {
		int response = JOptionPane.YES_OPTION;
		if(askConfirmation) {
			response = JOptionPane.showConfirmDialog(scoresView, "Are you sure?", "Delete all scores",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}
	    if(response == JOptionPane.YES_OPTION) {
	    	scoresModel.getScores().deleteAllScores();
	    	scoresModel.fireTableDataChanged();
	    	saveScores();
	    }
	}


	public void addScore(Player player) {
		String name = player.getName();
		if(name.isEmpty()) {
			name = JOptionPane.showInputDialog(scoresView, "New score", "Insert your name", JOptionPane.PLAIN_MESSAGE);
		}
		if(name != null) {
			if(!name.isEmpty()) {
				player.setName(name);
				scoresModel.getScores().addScore(player);
				scoresModel.fireTableDataChanged();
				saveScores();
			}
		}
	}
	
	
	public void loadScores() {
		Scores scores = null;
		try(
			InputStream file = new FileInputStream("scores.genius");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream (buffer);
	    ) {
			scores = (Scores)input.readObject();
	    }
	    catch(ClassNotFoundException | IOException ex) {
	    	scores = new Scores();
	    }
	    finally {
	    	if(scoresModel == null) {
	    		this.scoresModel = new ScoresTableModel(scores);
	    	} else {
	    		this.scoresModel.setScores(scores);
	    	}
		}
	}
	
	public void saveScores() {
		try (
			OutputStream file = new FileOutputStream("scores.genius");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
	    ){
			output.writeObject(scoresModel.getScores());
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		if(e.getActionCommand() == "Clear scores") {
			this.deleteScores(true);
		}
		
	}

}

