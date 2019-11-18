package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.util.Observable;

import java.util.ArrayList;
import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;

public class MOthello extends Observable {
	
	/** The commands. */
	private ArrayList<Command> commands = new ArrayList<>();
	
	/** The othello. */
	private Othello othello;
	
	/** The coordinate of the button on the OthelloBoard. */
	private String sCoord;
	
	/** Whether it is a coordinate or not. */
	private boolean change = false;
	
	/** The hint coord. */
	private String hintCoord = "";
	
	/** The hint available. */
	private boolean hintAvailable = false;
	
	/** The game over. */
	protected boolean gameOver = false;
	
	/** The AI Check. */
	private boolean AIC = false;
	
	
	/**
	 * Adds the command.
	 *
	 * @param c the command
	 */
	public void addCommand(Command c) {
		commands.add(c);
	}
	
	/**
	 * Operate.
	 */
	public void operate() {
		for (Command c : commands) {
			c.execute();
		}
		commands.clear();
	}
	
	/**
	 * Player.
	 *
	 * @param othello the othello game
	 * @param sCoord the button id that was clicked.
	 */
	public void player(Othello othello, String sCoord) { 
		this.othello = othello;
		if (sCoord.contains(",")) {
			this.change = true;
			this.hintAvailable = true;
		}
		this.sCoord = sCoord;
		this.notifyObservers();
	}
	
	/**
	 * Move.
	 *
	 * @param row the row
	 * @param col the col
	 */
	public void move(int row, int col) {
		this.othello.move(row, col);
		this.notifyObservers();
	}
	
	/**
	 * AI check, if an AI just moved or it is still HvH.
	 *
	 * @param s the string check.
	 */
	public void AICheck (String s) {
		if (!s.equals("H")) {
			this.AIC = true;
		}
		else {
			this.AIC = false;
		}
		this.notifyObservers();
	}
	
	/**
	 * Gets the boolean AIC.
	 *
	 * @return the AIC
	 */
	public boolean getAI() {
		return this.AIC;
	}
	
	/**
	 * Game over.
	 */
	public void gameOver() {
		this.gameOver = true;
		this.notifyObservers();
	}
	
	/**
	 * Reset game.
	 */
	public void resetGame() {
		this.gameOver = false;
	}
	
	/**
	 * Gets the token.
	 *
	 * @param row the row
	 * @param col the col
	 * @return the token on that space in the board.
	 */
	public char getToken(int row, int col) {
		return this.othello.getToken(row, col);
	}
	
	/**
	 * Gets the id of the button that was clicked.
	 *
	 * @return the sCoord.
	 */
	public String getStart() {
		return this.sCoord;
	}
	
	/**
	 * Gets the winner of the game.
	 *
	 * @return the winner.
	 */
	public String getWin() {
		if (this.othello.getWinner() == OthelloBoard.P1) {
			return "P1"; 
		}
		else {
			return "P2";
		}
	}
	
	/**
	 * Get whos turn from Othello.
	 *
	 * @return the whos turn
	 */
	public String getWhosTurn() {
		if (this.othello.getWhosTurn() == OthelloBoard.P1) {
			return "P1";
		}
		else {
			return "P2";
		}
		
	}
	
	/**
	 * Gets the change.
	 *
	 * @return the change
	 */
	public boolean getChange() {
		return this.change;
	}
	
	/**
	 * Player count.
	 *
	 * @return the string for the label playerCount in VOthello.
	 */
	public String playerCount() {
		String s = "";
		s += "Tokens (P1): " + this.othello.getCount(OthelloBoard.P1) + "    " + "Tokens (P2): " + this.othello.getCount(OthelloBoard.P2);
		return s;
	}
	
	/**
	 * Gets what coordinates to highlight on the board.
	 *
	 * @return ArrayList<String> coords
	 */
	public ArrayList<String> getHighlightBoard() {
		ArrayList<Move> moves = this.othello.getPossibleMoves();
		ArrayList<String> coords = new ArrayList<String>();
		for (Move move : moves) {
			coords.add(move.getRow()+","+move.getCol());
		}
		return coords;
	}
	
	/**
	 * Update hint.
	 */
	public void updateHint() {//
		this.hintCoord = this.othello.getHint();
		this.hintAvailable = false;
		this.notifyObservers();
	}
	
	/**
	 * Gets the hint.
	 *
	 * @return the hint
	 */
	public String getHint() {//
		return this.hintCoord;
	}
	
	/**
	 * Hint available.
	 *
	 * @return true, if successful
	 */
	public boolean hintAvailable() {
		return this.hintAvailable;
	}
	
	/**
	 * Reset hint.
	 */
	public void resetHint() {
		this.hintCoord = "";
	}
	
	/**
	 * Current winner.
	 *
	 * @return the string
	 */
	public String currentWinner() {
		String s = "Current Winner: ";
		if (this.othello.getCount(OthelloBoard.P1) > this.othello.getCount(OthelloBoard.P2)) {
			s += "P1";
		}
		else if (this.othello.getCount(OthelloBoard.P1) < this.othello.getCount(OthelloBoard.P2)) {
			s += "P2";	
		}
		else {
			s += "Tie";
		}
		
		return s;
	}
	
	
}
	


