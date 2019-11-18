package ca.utoronto.utm.othello.model;


/**
 * The Interface MVisitor.
 */
public interface MVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @param row the row
	 * @param col the col
	 * @param turn the turn
	 * @return true, if successful
	 */
	public boolean visit(OthelloBoard ob, int row, int col, char turn);
	
}
