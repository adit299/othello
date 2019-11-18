package ca.utoronto.utm.othello.model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Capture an Othello game. This includes an OthelloBoard as well as knowledge
 * of how many moves have been made, whosTurn is next (OthelloBoard.P1 or
 * OthelloBoard.P2). It knows how to make a move using the board and can tell
 * you statistics about the game, such as how many tokens P1 has and how many
 * tokens P2 has. It knows who the winner of the game is, and when the game is
 * over.
 * 
 * See the following for a short, simple introduction.
 * https://www.youtube.com/watch?v=Ol3Id7xYsY4
 * 
 * @author arnold
 *
 */
public class Othello{
	
	/** The Constant DIMENSION. */
	public static final int DIMENSION=8; // This is an 8x8 game
	
	/** The rand. */
	private Random rand = new Random();//
	
	/** The board. */
	private OthelloBoard board=new OthelloBoard(Othello.DIMENSION);
	
	/** The whos turn. */
	private char whosTurn = OthelloBoard.P1;
	
	/** The num moves. */
	private int numMoves = 0;
	
	/** The state. */
	private Stack state = new Stack();

	/**
	 * return P1,P2 or EMPTY depending on who moves next.
	 * 
	 * @return P1, P2 or EMPTY
	 */
	public char getWhosTurn() {
		return this.whosTurn;
	}
	
	/**
	 * undo the previous move during the game.
	 *
	 * @param AIC the aic
	 */
	public void undo(boolean AIC) {
		if (!this.state.empty() && AIC) {
			this.state.pop();
			this.state.pop();
			this.whosTurn = (char) this.state.pop();
			this.board = (OthelloBoard) this.state.pop();
		}
		else if (!this.state.empty()) {
			this.whosTurn = (char) this.state.pop();
			this.board = (OthelloBoard) this.state.pop();
		}
	}
	
	/**
	 * restarts the game from the beginning.
	 */
	public void restart() {
		this.board = new OthelloBoard(Othello.DIMENSION);
		this.whosTurn = OthelloBoard.P1;
		this.numMoves = 0;
		this.state.clear();
	}
	
	/**
	 * Gets the token.
	 *
	 * @param row the row
	 * @param col the col
	 * @return the token at position row, col.
	 */
	public char getToken(int row, int col) {
		TokenVisitor tv = new TokenVisitor();
		return(this.board.accept(tv, row, col));
	}

	/**
	 * Attempt to make a move for P1 or P2 (depending on whos turn it is) at
	 * position row, col. A side effect of this method is modification of whos turn
	 * and the move count.
	 *
	 * @param row the row
	 * @param col the col
	 * @return whether the move was successfully made.
	 */
	public boolean move(int row, int col) {
		this.state.push(this.copy().board);
		this.state.push(this.whosTurn);
		MoveVisitor mv = new MoveVisitor();
		if (this.board.accept(mv, row, col, this.whosTurn)) {
			this.whosTurn = OthelloBoard.otherPlayer(this.whosTurn);
			HasMoveVisitor hmv = new HasMoveVisitor();
			char allowedMove = this.board.accept(hmv);
			if(allowedMove!=OthelloBoard.BOTH)this.whosTurn=allowedMove;
			this.numMoves++;
			return true;
		} else {
			this.state.pop();
			this.state.pop();
			return false;
		}
	}


	/**
	 * Gets the count.
	 *
	 * @param player P1 or P2
	 * @return the number of tokens for player on the board
	 */
	public int getCount(char player) {
		CountVisitor cv = new CountVisitor();
		return(this.board.accept(cv, player));
	}
	
	/**
	 * Gets the mid count.
	 *
	 * @param player P1 or P2
	 * @return the number of middle 4x4 tokens for player on the board
	 */
	public int getMidCount(char player) {
		MCountVisitor mcv = new MCountVisitor();
		return(this.board.accept(mcv, player));
	}


	/**
	 * Returns the winner of the game.
	 * 
	 * @return P1, P2 or EMPTY for no winner, or the game is not finished.
	 */
	public char getWinner() {
		if(!this.isGameOver())return OthelloBoard.EMPTY;
		if(this.getCount(OthelloBoard.P1)> this.getCount(OthelloBoard.P2))return OthelloBoard.P1;
		if(this.getCount(OthelloBoard.P1)< this.getCount(OthelloBoard.P2))return OthelloBoard.P2;
		return OthelloBoard.EMPTY;
	}


	/**
	 * Checks if is game over.
	 *
	 * @return whether the game is over (no player can move next)
	 */
	public boolean isGameOver() {
		return this.whosTurn==OthelloBoard.EMPTY;
	}

	/**
	 * Copy.
	 *
	 * @return a copy of this. The copy can be manipulated without impacting this.
	 */
	public Othello copy() {
		Othello o= new Othello();
		o.board=this.board.copy();
		o.numMoves = this.numMoves;
		o.whosTurn = this.whosTurn;
		return o;
	}
	
	/**
	 * Gets the possible moves.
	 *
	 * @return the possible moves
	 */
	public ArrayList<Move> getPossibleMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int row=0;row<Othello.DIMENSION;row++) {
			for(int col=0;col<Othello.DIMENSION;col++) {
				Othello othelloCopy = this.copy();
				if(othelloCopy.move(row, col))
					moves.add(new Move(row,col));
			}
		}
		return moves;
	}
	
	/**
	 * Gets the hint.
	 *
	 * @return the hint
	 */
	public String getHint() {//
		ArrayList<Move> moves = getPossibleMoves();
		Move move = moves.get(this.rand.nextInt(moves.size()));
		int x = Othello.DIMENSION-move.getCol();
		int y = (move.getRow())+1;
		return "("+y+","+x+")";// wack coordinates cause of for loops
	}
	

	/**
	 * Gets the board string.
	 *
	 * @return a string representation of the board.
	 */
	public String getBoardString() {
		StringVisitor sv = new StringVisitor();
		return(this.board.accept(sv));
	}


	/**
	 * run this to test the current class. We play a completely random game. DO NOT
	 * MODIFY THIS!! See the assignment page for sample outputs from this.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args) {
		Random rand = new Random();


		Othello o = new Othello();
		System.out.println(o.getBoardString());
		while(!o.isGameOver()) {
			int row = rand.nextInt(8);
			int col = rand.nextInt(8);

			if(o.move(row, col)) {
				System.out.println("makes move ("+row+","+col+")");
				System.out.println(o.getBoardString()+ o.getWhosTurn()+" moves next");
			}
		}

	}
}


