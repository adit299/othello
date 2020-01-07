package ca.utoronto.utm.othello.model;

public class MoveVisitor implements MVisitor {
	/**
	 * Implementation of visitor to make 
	 * a move
	 * 
	 * 
	 * 
	 * 
	 * @param OthelloBoard
	 */

	public MoveVisitor() {}
	
	@Override
	public boolean visit(OthelloBoard ob, int row, int col, char turn) {
		return ob.move(row, col, turn);
	}
}
