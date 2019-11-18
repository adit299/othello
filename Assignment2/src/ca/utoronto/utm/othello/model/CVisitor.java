package ca.utoronto.utm.othello.model;

public interface CVisitor {

	public int visit(OthelloBoard ob, char player);
	
}
