package ca.utoronto.utm.othello.model;

public class HasMoveVisitor implements HMVisitor {

	@Override
	public char visit(OthelloBoard ob) {
		return ob.hasMove();
	}

}
