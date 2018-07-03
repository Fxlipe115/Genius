/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.player;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = -4326388715150172472L;
	private String name;
	private int score;
	
	public Player() {
		this.name = new String();
		this.score = 0;
	}
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore() {
		this.score++;
	}
	
}

