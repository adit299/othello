package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.util.Observable;

import java.util.ArrayList;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.othello.model.PlayerRandom;

public class MOthello extends Observable {
	
	private Othello othello;
	private String sCoord;
	private PlayerGreedy playerGreedy = new PlayerGreedy(othello, OthelloBoard.P2);
	private PlayerRandom playerRandom = new PlayerRandom(othello, OthelloBoard.P2);
	private boolean change = false;
	private String hintCoord = "";
	private boolean hintAvailable = false;
	protected boolean gameOver = false;
	
	
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
		String s = "Current Winner (Game in Progress): ";
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
	


