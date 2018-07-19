package models;

// Contains a list of the game's dice
public class DiceList {
	
	// Array of dice
	public GameDice[] gameDice = new GameDice[25];
	
	// Constructor
	public DiceList() {
		// 1 - 5
		this.gameDice[0] = new GameDice("Qu", "B", "Z", "J", "X", "K");
		this.gameDice[1] = new GameDice("T", "O", "U", "O", "T", "O");
		this.gameDice[2] = new GameDice("O", "V", "W", "R", "G", "R");
		this.gameDice[3] = new GameDice("A", "A", "A", "F", "S", "R");
		this.gameDice[4] = new GameDice("A", "U", "M", "E", "E", "G");
		
		// 6 - 10
		this.gameDice[5] = new GameDice("H", "H", "L", "R", "D", "O");
		this.gameDice[6] = new GameDice("N", "H", "D", "T", "H", "O");
		this.gameDice[7] = new GameDice("L", "H", "N", "R", "O", "D");
		this.gameDice[8] = new GameDice("A", "F", "A", "I", "S", "R");
		this.gameDice[9] = new GameDice("Y", "I", "F", "A", "S", "R");
		
		// 11 - 15
		this.gameDice[10] = new GameDice("T", "E", "L", "P", "C", "I");
		this.gameDice[11] = new GameDice("S", "S", "N", "S", "E", "U");
		this.gameDice[12] = new GameDice("R", "I", "Y", "P", "R", "H");
		this.gameDice[13] = new GameDice("D", "O", "R", "D", "L", "N");
		this.gameDice[14] = new GameDice("C", "C", "W", "N", "S", "T");
		
		// 16 - 20
		this.gameDice[15] = new GameDice("T", "T", "O", "T", "E", "M");
		this.gameDice[16] = new GameDice("S", "C", "T", "I", "E", "P");
		this.gameDice[17] = new GameDice("E", "A", "N", "D", "N", "N");
		this.gameDice[18] = new GameDice("M", "N", "N", "E", "A", "G");
		this.gameDice[19] = new GameDice("U", "O", "T", "O", "W", "N");
		
		// 21 - 25
		this.gameDice[20] = new GameDice("A", "E", "A", "E", "E", "E");
		this.gameDice[21] = new GameDice("Y", "I", "F", "P", "S", "R");
		this.gameDice[22] = new GameDice("E", "E", "E", "E", "M", "A");
		this.gameDice[23] = new GameDice("I", "T", "I", "T", "I", "E");
		this.gameDice[24] = new GameDice("E", "T", "I", "L", "I", "C");
	}

}
