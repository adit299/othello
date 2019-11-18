package ca.utoronto.utm.othello.model;


/**
 * The Class CountVisitor.
 */
public class CountVisitor implements CVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @param player the player
	 * @return the int
	 */
	@Override
	public int visit(OthelloBoard ob, char player) {
		return ob.getCount(player);
	}

}
