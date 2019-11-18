package ca.utoronto.utm.othello.model;

/**
 * The Class StringVisitor.
 */
public class StringVisitor implements SVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the OthelloBoard
	 * @return the board in string form
	 */
	@Override
	public String visit(OthelloBoard ob) {
		return ob.toString();
	}

}
