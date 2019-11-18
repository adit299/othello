package ca.utoronto.utm.othello.model;

public interface MVisitor {

	public boolean visit(OthelloBoard ob, int row, int col, char turn);
	
}
