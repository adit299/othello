package ca.utoronto.utm.othello.model;


/**
 * The Class MoveVisitor.
 */
public class MoveVisitor implements MVisitor {

	/**
	 * Instantiates a new move visitor.
	 */
	public MoveVisitor() {}
	
	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @param row the row
	 * @param col the col
	 * @param turn the turn
	 * @return true, if successful
	 */
	@Override
	public boolean visit(OthelloBoard ob, int row, int col, char turn) {
		return ob.move(row, col, turn);
	}
}
