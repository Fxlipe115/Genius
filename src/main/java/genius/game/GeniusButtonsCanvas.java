/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.game;

import java.awt.Canvas;
import java.awt.Color;

import genius.types.Button;

@SuppressWarnings("serial")
public class GeniusButtonsCanvas extends Canvas{
	private Button value;
	private boolean turnedOn;
	private Color color;
	
	public GeniusButtonsCanvas(Button value, Color color) {
		this.value = value;
		this.color = color;
		this.setTurnedOn(false);
	}
	
	public GeniusButtonsCanvas(Color buttonColor) {
		this.setBackground(buttonColor);
	}

	public Button getValue() {
		return value;
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(boolean turnedOn) {
		this.turnedOn = turnedOn;
		if(turnedOn) {
			this.setBackground(color.brighter());
		} else {
			this.setBackground(color.darker());
		}
	}
	


}
