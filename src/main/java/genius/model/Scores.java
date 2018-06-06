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
	 *
	 */
	public void addScore(Player player) {
		
	//Adiciona novo jogador à lista da Scores e ordena.	
	
		this.scores.add(player);
		this.sort(); 
	}
	
	public List<Player> getScores() {
		return scores;
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
	
	//Deleta um Score, e reorganiza todos os restantes subtraindo 1 de seus índices.
		
		this.scores.remove(index);
	}

	
	private void sort(){
		
	//Ordena a lista da scores baseado no score de cada jogador incluso.
		
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

