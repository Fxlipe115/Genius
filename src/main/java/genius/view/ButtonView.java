package genius.view;

import java.awt.Canvas;
import java.awt.Color;
import genius.model.Button;

@SuppressWarnings("serial")
public class ButtonView extends Canvas{
	private Button value;
	
	public ButtonView(Button value) {
		this.value = value;
	}
	
	public ButtonView(Color buttonColor) {
		this.setBackground(buttonColor);
	}

	public Button getValue() {
		return value;
	}

}
