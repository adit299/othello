package ca.utoronto.utm.othello.model;

public class StringVisitor implements SVisitor {

	@Override
	public String visit(OthelloBoard ob) {
		return ob.toString();
	}

}
