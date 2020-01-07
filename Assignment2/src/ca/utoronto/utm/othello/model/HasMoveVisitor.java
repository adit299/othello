package ca.utoronto.utm.othello.model;

public class HasMoveVisitor implements HMVisitor {
	
	/**
	 * Implementation of visitor to check if any
	 * moves are available
	 * 
	 * 
	 * 
	 * @param OthelloBoard
	 */

	@Override
	public char visit(OthelloBoard ob) {
		return ob.hasMove();
	}

}
