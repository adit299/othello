package ca.utoronto.utm.othello.model;

public class MCountVisitor implements CVisitor {
	
	/**
	 * Implementation of visitor to check the 
	 * number of middle pieces player has
	 * 
	 * 
	 * 
	 * @param OthelloBoard
	 */

	@Override
	public int visit(OthelloBoard ob, char player) {
		return ob.getMidCount(player);
	}

}
