package genius.button;

import java.awt.Canvas;
import java.awt.Color;

@SuppressWarnings("serial")
public class ButtonView extends Canvas{
	private Button value;
	private boolean turnedOn;
	private Color color;
	
	public ButtonView(Button value, Color color) {
		this.value = value;
		this.color = color;
		this.setTurnedOn(false);
	}
	
	public ButtonView(Color buttonColor) {
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
