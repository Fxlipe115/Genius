/*
 * Final project for the course TÃ©cnicas de ConstruÃ§Ã£o de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de InformÃ¡tica
 *
 * Created : May 13, 2018
 * Author  : Henrique Barboza
 */
package genius.model;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * @author Henrique Barboza
 *
 */
public class Scores extends java.util.Observable implements Serializable{
	
	
	private static final long serialVersionUID = 4258750736263856738L;
	
	private List<Player> scores;


	
	public Scores(){

		
		this.scores = new ArrayList<Player>();
	}
	/**
	 *@param PLAYER[
	 * 
	 * Method adds a new score to the list if
	 * it is amongst the top 10 scores.
	 *  
	 */
	public void addScore(Player player) {
	
		if(this.scores.size() >= 10)
		{
			this.scores.add(player);
			this.sort();
			this.scores.remove(10);   //Removes the 11th score, keeps it at 10.
		}
		else
		{
			this.scores.add(player);
			this.sort();
		}
	}
	
	/**
	 * 
	 */
	public List<Player> getScores() {
		return scores;
	}
	/**
	 * Cleans scores list
	 * 
	 */
	public void deleteAllScores() {

		
		this.scores.clear();
	}

	/**
	 * @param index
	 * 
	 * Deletes score from index
	 *
	 */
	public void deleteScore(int index) {
		
		this.scores.remove(index);
	}

	/**
	 * 	Sorts score list based on each player's score
	 * 
	 */
	private void sort(){
		
		
		Collections.sort(scores, Collections.reverseOrder(new Comparator<Player>() {
	        @Override
	        public int compare(Player player1, Player player2)
	        {
	        	return Integer.valueOf(player1.getScore()).compareTo(Integer.valueOf(player2.getScore()));
	        }
	    }));
		
	}
	
	/**
	 */ 


}

