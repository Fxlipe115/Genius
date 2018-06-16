/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.model;


/**
 * @author Graeff
 *
 */
public enum Difficulty {
	EASY(8), MEDIUM(14), HARD(20), EXTREME(31);
	
	private final int difficulty;

	private Difficulty(int difficulty) {
    	this.difficulty = difficulty;
	}
    
    public int getValue(){
        return difficulty;
    }
}
