package models;

// Class representing a game dice (25 total)
public class GameDice {

	// List of characters on each side of the dice
	public String[] sides = new String[6];
	
	// Creates a dice
	public GameDice(String s1, String s2, String s3, String s4, String s5, String s6) {
		this.sides[0] = s1;
		this.sides[1] = s2;
		this.sides[2] = s3;
		this.sides[3] = s4;
		this.sides[4] = s5;
		this.sides[5] = s6;
	}
	
}
