package genius.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;

import genius.model.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class GeniusGUI extends AbstractButton {
	private Button pressedButton;
	private int width;
	private int height;
	
	private ButtonModel model;
	
	private static final Color GREEN_BUTTON_COLOR = Color.GREEN;
	private static final Color RED_BUTTON_COLOR = Color.RED;
	private static final Color YELLOW_BUTTON_COLOR = Color.YELLOW;
	private static final Color BLUE_BUTTON_COLOR = Color.BLUE;

	public GeniusGUI(int width, int height) {
		model = new DefaultButtonModel();
		setModel(model);
		this.pressedButton = null;
		this.width = width;
		this.height = height;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pressedButton == null && model.isEnabled()) {
					int x = e.getX(), y = e.getY();
					int modifier = 0;
	
					if (x > 0 && x < width / 2 && y > 0 && y < height / 2)
					{
						modifier = Button.GREEN.ordinal();
					}
					else if (x > width / 2 && x < width && y > 0 && y < height / 2)
					{
						modifier = Button.RED.ordinal();
					}
					else if (x > 0 && x < width / 2 && y > height / 2 && y < height)
					{
						modifier = Button.BLUE.ordinal();
					}
					else if (x > width / 2 && x < width && y > height / 2 && y < height)
					{
						modifier = Button.YELLOW.ordinal();
					}
					
					ActionEvent ae = new ActionEvent(e, e.getID(), "click", 0, modifier);
					fireActionPerformed(ae);
				}
			}
		});
		repaint();
	}
	
	
	public void setPressedButton(Button pressedButton) {
		this.pressedButton = pressedButton;
		if(pressedButton != null) {
			int delay = 750;
			Timer t = new Timer(delay, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ActionEvent ae = new ActionEvent(this, 0, "wait");
					fireActionPerformed(ae);
				}
			});
			t.setRepeats(false);
			t.start();
		}
		repaint();
	}

	
	/* 
	 * @author Jaryt
	 * @see https://github.com/Jaryt/SimonTutorial/blob/master/src/simon/Simon.java
	 */
	@Override
	public void paint(Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (pressedButton == Button.GREEN)
		{
			g.setColor(GREEN_BUTTON_COLOR.brighter());
		}
		else
		{
			g.setColor(GREEN_BUTTON_COLOR.darker());
		}

		g.fillRect(0, 0, width/2, height/2);

		if (pressedButton == Button.RED)
		{
			g.setColor(RED_BUTTON_COLOR.brighter());
		}
		else
		{
			g.setColor(RED_BUTTON_COLOR.darker());
		}

		g.fillRect(width/2, 0, width/2, height/2);

		if (pressedButton == Button.BLUE)
		{
			g.setColor(BLUE_BUTTON_COLOR.brighter());
		}
		else
		{
			g.setColor(BLUE_BUTTON_COLOR.darker());
		}

		g.fillRect(0, height/2, width/2, height/2);

		if (pressedButton == Button.YELLOW)
		{
			g.setColor(YELLOW_BUTTON_COLOR.brighter());
		}
		else
		{
			g.setColor(YELLOW_BUTTON_COLOR.darker());
		}

		g.fillRect(width / 2, height / 2, width / 2, height / 2);

		g.setColor(Color.BLACK);
		int roundRectWidth = 7 * width / 16;
		int roundRectHeight = 7 * height/16;
		int roundRectX = (width/2) - (roundRectWidth/2);
		int roundRectY = (height/2) - (roundRectHeight/2);
		int roundRectArcWidth = 3 * width / 8;
		int roundRectArcHeight = 3 * height / 8;
		g.fillRoundRect(roundRectX, roundRectY, roundRectWidth, roundRectHeight, roundRectArcWidth, roundRectArcHeight);
		
		int horizontalRectWidth = width / 7;
		int horizontalRectHeight = height;
		int horizontalRectX = (width/2) - (horizontalRectWidth/2);
		int horizontalRectY = 0;
		g.fillRect(horizontalRectX, horizontalRectY, horizontalRectWidth, horizontalRectHeight);
		
		int verticalRectWidth = width;
		int verticalRectHeight = height / 7;
		int verticalRectX = 0;
		int verticalRectY = (height/2) - (verticalRectHeight/2);
		g.fillRect(verticalRectX, verticalRectY, verticalRectWidth, verticalRectHeight);

		g.setColor(Color.GRAY);
		((Graphics2D) g).setStroke(new BasicStroke(200));
		g.drawOval(-100, -100, width + 200, height + 200);

		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(10));
		g.drawOval(0, 0, width, height);
	}
	
}
