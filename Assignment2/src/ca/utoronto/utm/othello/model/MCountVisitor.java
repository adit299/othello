package ca.utoronto.utm.othello.model;

public class MCountVisitor implements CVisitor {

	@Override
	public int visit(OthelloBoard ob, char player) {
		return ob.getMidCount(player);
	}

}
