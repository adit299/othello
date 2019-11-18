package ca.utoronto.utm.othello.model;


/**
 * The Interface CVisitor.
 */
public interface CVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @param player the player
	 * @return the int
	 */
	public int visit(OthelloBoard ob, char player);
	
}
