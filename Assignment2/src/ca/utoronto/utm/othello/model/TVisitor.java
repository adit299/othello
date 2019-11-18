package ca.utoronto.utm.othello.model;


/**
 * The Interface TVisitor.
 */
public interface TVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @param row the row
	 * @param col the col
	 * @return the char
	 */
	public char visit(OthelloBoard ob, int row, int col);
		
}
