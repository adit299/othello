package ca.utoronto.utm.othello.model;


/**
 * The Class HasMoveVisitor.
 */
public class HasMoveVisitor implements HMVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @return the char
	 */
	@Override
	public char visit(OthelloBoard ob) {
		return ob.hasMove();
	}

}
