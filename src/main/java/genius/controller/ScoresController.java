/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.controller;
import genius.view.ScoresDialog;
import genius.model.Scores;


/**
 * @author Graeff
 *
 */
public class ScoresController {
	/**
	 * 
	 */
	private Scores scoresModel;

	/**
	 * 
	 */
	private ScoresDialog scoresView;

	
	/**
	 * 
	 */
	public ScoresController(){
		scoresModel = new Scores();
		scoresView = new ScoresDialog();
	}

	
	/**
	 * 
	 */
	public void showScores() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void deleteScores() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void addScore() {
		// TODO implement me
	}

}

