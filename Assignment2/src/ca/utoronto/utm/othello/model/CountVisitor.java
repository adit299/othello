package ca.utoronto.utm.othello.model;

public class CountVisitor implements CVisitor {
	
	/**
	 * Implementation of visitor to count player tokens
	 * 
	 * 
	 * 
	 * @param OthelloBoard, Player
	 */

	@Override
	public int visit(OthelloBoard ob, char player) {
		return ob.getCount(player);
	}

}
