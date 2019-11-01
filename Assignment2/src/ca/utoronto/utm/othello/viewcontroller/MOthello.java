package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.othello.model.Othello;

public class MOthello extends Observable {
	
	private Othello othello;
	private String sCoord;
	protected boolean gameOver = false;
	
	public void player(Othello othello, String sCoord) { 
		this.othello = othello;
		this.sCoord = sCoord;
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
}
	


