package ca.utoronto.utm.othello.model;


/**
 * The Interface HMVisitor.
 */
public interface HMVisitor {

	/**
	 * Visit.
	 *
	 * @param ob the ob
	 * @return the char
	 */
	public char visit(OthelloBoard ob);
	
}
