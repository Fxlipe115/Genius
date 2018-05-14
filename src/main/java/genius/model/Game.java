/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.model;
import java.util.List;


/**
 * @author Graeff
 *
 */
public class Game {
	/**
	 * 
	 */
	private List<Button> sequence;

	/**
	 * 
	 */
	private int currentIndex;

	/**
	 * 
	 */
	protected Player player;


	/**
	 * 
	 */
	public Game(){
		super();
	}

	
	/**
	 * @param size
	 */
	private void generateSequence(int size) {
		// TODO implement me
	}

	
	/**
	 * @return
	 */
	public Button getNextButton() {
		// TODO implement me
		return Button.RED;
	}

	
	/**
	 * @return
	 */
	public Button getButtonAt() {
		// TODO implement me
		return Button.RED;
	}

	
	/**
	 * @param button
	 * @return
	 */
	public boolean isCorrect(Button button) {
		// TODO implement me
		return false;
	}

}

