package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.othello.model.PlayerRandom;

public class MOthello extends Observable {
	
	private Othello othello;
	private String sCoord;
	private String sText;
	private PlayerGreedy playerGreedy;
	private PlayerRandom playerRandom;
	private boolean change = false;
	private String hintCoord = "()";
	private boolean hintAvailable = false;
	protected boolean gameOver = false;
	
	
	public void player(Othello othello, String sCoord) { 
		this.othello = othello;
		if (sCoord != this.sCoord) {
			this.change = true;
		}
		this.sCoord = sCoord;
		this.hintAvailable = true;
		this.notifyObservers();
	}
	
	public Move greedyMove() {
		return playerGreedy.getMove();
		
	}
	
	public Move randomMove() {
		return playerRandom.getMove();
	}
	
	public void cPlayer(Othello othello, String sText) {
		this.othello = othello;
		this.sText = sText;
		this.notifyObservers();
	}
	
	public void gameOver() {
		this.gameOver = true;
		this.notifyObservers();
	}
	
	public char getToken(int row, int col) {
		return this.othello.getToken(row, col);
	}
	
	public String getStart() {
		return this.sCoord;
	}
	
	public String getSText() {
		return this.sText;
	}
	
	public char getWin() {
		return this.othello.getWinner();
	}
	
	public char getWhosTurn() {
		return this.othello.getWhosTurn();
	}
	
	public boolean getChange() {
		return this.change;
	}
	
	public String playerCount() {
		String s = "";
		s += "Tokens (P1): " + this.othello.getCount(OthelloBoard.P1) + "    " + "Tokens (P2): " + this.othello.getCount(OthelloBoard.P2);
		return s;
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
	
	public String currentWinner() {
		String s = "Current Winner: ";
		if (this.othello.getCount(OthelloBoard.P1) > this.othello.getCount(OthelloBoard.P2)) {
			s += OthelloBoard.P1;
		}
		else if (this.othello.getCount(OthelloBoard.P1) < this.othello.getCount(OthelloBoard.P2)) {
			s += OthelloBoard.P2;	
		}
		else {
			s += "Tie";
		}
		
		return s;
	}
	
	
}
	


