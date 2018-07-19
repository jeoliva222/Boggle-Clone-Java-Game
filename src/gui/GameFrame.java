package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import models.GameDice;

public class GameFrame extends JFrame implements KeyListener {

	// Prevents warnings
	private static final long serialVersionUID = 1L;
	
	// Width and Height of the frame
	private static int fWidth = 438;
	private static int fHeight = 600;
	
	// Count of the in-game timer
	private int timerCount = 120;
	
	// Panel that contains the game itself
	private BogglePanel bogglePanel;
	
	// Button that starts a game
	private JButton startButton;
	
	// Button that pauses the current game
	private JButton pauseButton;
	
	// Label that displays the timer
	private JLabel timerLabel;
	
	// Second timer
	private Timer secTimer;
	
	// Flag for whether game is pause or now
	private boolean isPaused = false;
	
	// Constructor
	public GameFrame() {
		super();
		
		// Set size attributes of frame
		Dimension size = new Dimension(GameFrame.fWidth, GameFrame.fHeight);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setResizable(false);
		
		// Add Key Listener
		this.addKeyListener(this);
		
		// Set Layout to null (Direct positioning)
		this.setLayout(null);
		
		// Add in the Boggle panel
		this.bogglePanel = new BogglePanel();
		this.bogglePanel.setBounds(10, 10, BogglePanel.gWidth, BogglePanel.gHeight);
		this.add(bogglePanel);
		
		// Add in the start button
		this.startButton = new JButton("Start New Game");
		this.startButton.setBounds(20, 450, 150, 40);
		this.startButton.setFocusPainted(false);
		this.startButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				GameFrame.this.startGame();
			  } 
		});
		this.add(startButton);
		
		// Add in the pause button
		this.pauseButton = new JButton("Pause");
		this.pauseButton.setBounds(20, 500, 150, 40);
		this.pauseButton.setFocusPainted(false);
		this.pauseButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				GameFrame.this.togglePause();
			  } 
		});
		this.add(pauseButton);
		
		// Add in the timer label
		this.timerLabel = new JLabel("Timer: " + Integer.toString(this.timerCount));
		this.timerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		this.timerLabel.setBounds(280, 450, 150, 40);
		this.add(timerLabel);
		
		// Set background
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// Create the timer
		this.secTimer = new Timer();
		
		// Prepare frame for viewing
		this.setTitle("Boggle Clone");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setAutoRequestFocus(true);
		this.setVisible(true);
		this.pack();
	}
	
	// Starts a new game of Boggle Clone
	public void startGame() {	
		
		// Set Pause variables back to normal
		this.pauseButton.setText("Pause");
		this.isPaused = false;
		
		// Stop timer
		this.secTimer.cancel();
		this.secTimer.purge();
		
		// Shuffle the Dice
		this.shuffleDice();
		
		// For each dice, pick a random side to display
		int xInd = 0;
		int yInd = 0;
		Random r = new Random();
		for(GameDice dice: this.bogglePanel.allDice.gameDice) {
			String displayText = dice.sides[r.nextInt(6)];
			this.bogglePanel.tiles[yInd][xInd].setText(displayText);
			xInd += 1;
			
			if(xInd >= 5) {
				xInd = 0;
				yInd += 1;
			}
		}
		
		// Reset background
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// Set the timer count to 120
		this.timerCount = 120;
		this.timerLabel.setText("Timer: " + Integer.toString(this.timerCount));
		
		// Repaint the frame
		this.repaint();
		
		// Restart the timer
		this.secTimer = new Timer();
		TimerTask secondTick = new TimerTask() {
			@Override
			public void run() {
				GameFrame.this.timerTick();
			}
		};
		this.secTimer.schedule(secondTick, 1000, 1000);
	}
	
	// Shuffles the dice into random positions
	public void shuffleDice() {
		Random r = new Random();
		for(int i = 24; i > 0; i--) {
			// Generate random index to swap with
			int shufIndex = r.nextInt(i + 1);
			
			// Swap the positions
			GameDice temp = this.bogglePanel.allDice.gameDice[i];
			this.bogglePanel.allDice.gameDice[i] = this.bogglePanel.allDice.gameDice[shufIndex];
			this.bogglePanel.allDice.gameDice[shufIndex] = temp;
		}
	}
	
	// Control for the pause button that toggles the timer
	private void togglePause() {
		// If we are paused, un-pause the game
		if(this.isPaused) {
			// Change button text
			this.pauseButton.setText("Pause");
			
			// Resume the timer
			this.secTimer = new Timer();
			TimerTask secondTick = new TimerTask() {
				@Override
				public void run() {
					GameFrame.this.timerTick();
				}
			};
			this.secTimer.schedule(secondTick, 1000, 1000);
		} else {
			// Otherwise, pause the game
			
			// Change button text
			this.pauseButton.setText("Un-pause");
			
			// Stop timer
			this.secTimer.cancel();
			this.secTimer.purge();
		}
		
		// Toggle pause status
		this.isPaused = !(this.isPaused);
	}
	
	// Action for the game timer (Run once every second when the timer is going)
	public void timerTick() {
		// Subtract one second from the timer per tick
		this.timerCount += -1;
		
		// Based on the time remaining, set a background color for the screen
		if(this.timerCount <= 0) {
			this.timerCount = 0;
			this.getContentPane().setBackground(Color.RED);
		} else if(this.timerCount <= 10) {
			this.getContentPane().setBackground(Color.ORANGE);
		} else if(this.timerCount <= 30) {
			this.getContentPane().setBackground(Color.YELLOW);
		}
		
		// Change the timer text to reflect the updated time
		this.timerLabel.setText("Timer: " + Integer.toString(this.timerCount));
		this.repaint();
	}
	
	//----------------------------------------
	// KeyListener Functions
	
	@Override
	public void keyPressed(KeyEvent e) {
		// SPACE key starts a new game
		// P key toggles the pause status of the current game
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.startGame();
	    } else if(e.getKeyCode() == KeyEvent.VK_P) {
	    	this.togglePause();
	    }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Nothing	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// Nothing
	}
	
}
