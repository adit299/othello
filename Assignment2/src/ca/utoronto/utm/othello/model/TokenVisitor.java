package ca.utoronto.utm.othello.model;

public class TokenVisitor implements TVisitor {
	/**
	 * Implementation of visitor to check if any
	 * moves are available
	 * 
	 * 
	 * 
	 * @param OthelloBoard
	 */

	public TokenVisitor() {}
	
	@Override
	public char visit(OthelloBoard ob, int row, int col) {
		return ob.get(row, col);
	}

}
