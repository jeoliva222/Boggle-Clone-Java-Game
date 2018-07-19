package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import models.DiceList;

// Panel which displays all of the BoggleTiles (letter-containing tiles)
public class BogglePanel extends JPanel {

	// Prevents warnings
	private static final long serialVersionUID = 1L;

	// Width and height of the game
	protected static int gWidth = 400;
	protected static int gHeight = 400;
	
	// 5 X 5 grid of square letter-containing tiles
	protected BoggleTile[][] tiles = new BoggleTile[5][5];
	
	// List of dice used by the game
	protected DiceList allDice = new DiceList();
	
	// Constructor
	public BogglePanel() {
		super();
		
		// Set Layout to a 5 X 5 grid
		this.setLayout(new GridLayout(5, 5));
		
		// Populate frame with squares
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 5; x++) {
				// Add new square
				BoggleTile tile = new BoggleTile();
				this.tiles[y][x] = tile;
				this.add(tile);
			}
		}
		
		// Prepare panel for viewing
		this.setVisible(true);
	}

}
