package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.util.Observable;

import java.util.ArrayList;
import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;

public class MOthello extends Observable {
	
	private ArrayList<Command> commands = new ArrayList<>();
	private Othello othello;
	private String sCoord;
	private boolean change = false;
	private String hintCoord = "";
	private boolean hintAvailable = false;
	protected boolean gameOver = false;
	private boolean AIC = false;
	
	
	public void addCommand(Command c) {
		commands.add(c);
	}
	
	public void operate() {
		for (Command c : commands) {
			c.execute();
		}
		commands.clear();
	}
	
	public void player(Othello othello, String sCoord) { 
		this.othello = othello;
		if (sCoord.contains(",")) {
			this.change = true;
			this.hintAvailable = true;
		}
		this.sCoord = sCoord;
		this.notifyObservers();
	}
	
	public void move(int row, int col) {
		this.othello.move(row, col);
		this.notifyObservers();
	}
	
	public void AICheck (String s) {
		if (!s.equals("H")) {
			this.AIC = true;
		}
		else {
			this.AIC = false;
		}
		this.notifyObservers();
	}
	
	public boolean getAI() {
		return this.AIC;
	}
	
	public void gameOver() {
		this.gameOver = true;
		this.notifyObservers();
	}
	
	public void resetGame() {
		this.gameOver = false;
	}
	
	public char getToken(int row, int col) {
		return this.othello.getToken(row, col);
	}
	
	public String getStart() {
		return this.sCoord;
	}
	
	public String getWin() {
		if (this.othello.getWinner() == OthelloBoard.P1) {
			return "P1"; 
		}
		else {
			return "P2";
		}
	}
	
	public String getWhosTurn() {
		if (this.othello.getWhosTurn() == OthelloBoard.P1) {
			return "P1";
		}
		else {
			return "P2";
		}
		
	}
	
	public boolean getChange() {
		return this.change;
	}
	
	public String playerCount() {
		String s = "";
		s += "Tokens (P1): " + this.othello.getCount(OthelloBoard.P1) + "    " + "Tokens (P2): " + this.othello.getCount(OthelloBoard.P2);
		return s;
	}
	
	public ArrayList<String> getHighlightBoard() {
		ArrayList<Move> moves = this.othello.getPossibleMoves();
		ArrayList<String> coords = new ArrayList<String>();
		for (Move move : moves) {
			coords.add(move.getRow()+","+move.getCol());
		}
		return coords;
	}
	
	public void updateHint() {//
		this.hintCoord = this.othello.getHint();
		this.hintAvailable = false;
		this.notifyObservers();
	}
	
	public String getHint() {//
		return this.hintCoord;
	}
	
	public boolean hintAvailable() {
		return this.hintAvailable;
	}
	
	public void resetHint() {
		this.hintCoord = "";
	}
	
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
	


