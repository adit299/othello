package ca.utoronto.utm.othello.model;

public interface Visitable{

	public char accept(TVisitor visitor, int row, int col); //token
	
	public char accept(HMVisitor visitor);
	
	public boolean accept(MVisitor visitor, int row, int col, char turn); //move
	
	public int accept(CVisitor visitor, char player); //count or mcount
	
	public String accept(SVisitor visitor); //board string
	
	
}
