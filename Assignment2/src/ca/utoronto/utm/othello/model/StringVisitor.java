package ca.utoronto.utm.othello.model;

public class StringVisitor implements SVisitor {
	/**
	 * Implementation of visitor to get the board string
	 * 
	 * 
	 * 
	 * @param OthelloBoard
	 */

	@Override
	public String visit(OthelloBoard ob) {
		return ob.toString();
	}

}
