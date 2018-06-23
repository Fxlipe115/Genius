/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 13, 2018
 * Author  : 
 */
package genius.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import genius.button.Button;
import genius.player.Player;


/**
 * @author Graeff
 *
 */
public class Game extends java.util.Observable{
	private List<Button> sequence;
	private Player player;


	public Game(){
		sequence = null;
		player = null;
	}

	
	public void generateSequence(int size) {
		Random random = new Random();
		sequence = new ArrayList<Button>(size);
		for(int i = 0; i < size; i++) {
			int newButtonIndex = random.nextInt(Button.values().length);
			Button newButton = Button.values()[newButtonIndex];
			sequence.add(i, newButton);
		}
	}

	
	public List<Button> getSequence() {
		return sequence;
	}
	

	public Player getPlayer() {
		return player;
	}

}
