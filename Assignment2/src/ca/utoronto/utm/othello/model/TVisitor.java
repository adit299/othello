package ca.utoronto.utm.othello.model;

public interface TVisitor {

	public char visit(OthelloBoard ob, int row, int col);
		
}
