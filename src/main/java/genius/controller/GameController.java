/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.controller;
import genius.view.GameDialog;
import genius.model.Game;


/**
 * @author Graeff
 *
 */
public class GameController {
	/**
	 * 
	 */
	private Game gameModel;

	/**
	 * 
	 */
	private GameDialog gameView;

	
	/**
	 * 
	 */
	public GameController(){
		gameModel = new Game();
		gameView = new GameDialog();
	}

		
	/**
	 * 
	 */
	public void playSequence() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void nextStep() {
		// TODO implement me
	}

	
	/**
	 * 
	 */
	public void pause() {
		// TODO implement me
	}

}

