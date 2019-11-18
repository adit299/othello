package ca.utoronto.utm.othello.model;

public class CountVisitor implements CVisitor {

	@Override
	public int visit(OthelloBoard ob, char player) {
		return ob.getCount(player);
	}

}
