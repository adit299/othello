package ca.utoronto.utm.othello.model;


/**
 * The Class TokenVisitor.
 */
public class TokenVisitor implements TVisitor {

	/**
	 * Instantiates a new token visitor.
	 */
	public TokenVisitor() {}
	
	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @param row the row
	 * @param col the col
	 * @return the char
	 */
	@Override
	public char visit(OthelloBoard ob, int row, int col) {
		return ob.get(row, col);
	}

}
