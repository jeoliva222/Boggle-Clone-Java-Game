package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Class that represent one of the 25 tiles (showed in a 5 X 5 pattern)
// that display letters on the game board
public class BoggleTile extends JPanel {

	// Prevents warnings
	private static final long serialVersionUID = 1L;
	
	// Label showing text
	private JLabel label = new JLabel();
	
	// Constructor
	public BoggleTile() {
		super();
		
		// Add label
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		this.add(label);
		
		// Add border
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}
	
	// Sets the text for the tile's label
	public void setText(String text) {
		this.label.setText(text);
	}
	
	
}
