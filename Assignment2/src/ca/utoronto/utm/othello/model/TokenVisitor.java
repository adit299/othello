package ca.utoronto.utm.othello.model;

public class TokenVisitor implements TVisitor {

	public TokenVisitor() {}
	
	@Override
	public char visit(OthelloBoard ob, int row, int col) {
		return ob.get(row, col);
	}

}
