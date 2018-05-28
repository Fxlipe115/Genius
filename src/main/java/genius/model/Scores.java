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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * @author Graeff
 *
 */
public class Scores extends java.util.Observable implements Serializable{
	
	
	private static final long serialVersionUID = 4258750736263856738L;
	
	private List<Player> scores;


	
	public Scores(){

		
		this.scores = new ArrayList<Player>();
	}
	/**
	 *
	 */
	public void addScore(Player player) {
		
	//Adiciona novo jogador � lista da Scores e ordena.	
	
		this.scores.add(player);
		this.sort(); 
	}
	/**
	 * 
	 */
	public void deleteAllScores() {

	//Limpa a lista de scores.
		
		this.scores.clear();
	}

	/**
	 * @param index
	 */
	public void deleteScore(int index) {
	
	//Deleta um Score, e reorganiza todos os restantes subtraindo 1 de seus �ndices.
		
		this.scores.remove(index);
	}

	
	private void sort(){
		
	//Ordena a lista da scores baseado no score de cada jogador incluso.
		
		Collections.sort(scores, new Comparator<Player>() {
	        @Override
	        public int compare(Player player1, Player player2)
	        {
	        	return Integer.valueOf(player1.getScore()).compareTo(Integer.valueOf(player2.getScore()));
	        }
	    });
		
	}
	
	/**
	 */ 


}

