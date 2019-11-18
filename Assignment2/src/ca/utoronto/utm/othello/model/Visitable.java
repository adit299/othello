package ca.utoronto.utm.othello.model;


/**
 * The Interface Visitable.
 */
public interface Visitable{

	/**
	 * Accept.
	 *
	 * @param visitor the visitor
	 * @param row the row
	 * @param col the col
	 * @return the char
	 */
	public char accept(TVisitor visitor, int row, int col); //token
	
	/**
	 * Accept.
	 *
	 * @param visitor the visitor
	 * @return the char
	 */
	public char accept(HMVisitor visitor);
	
	/**
	 * Accept.
	 *
	 * @param visitor the visitor
	 * @param row the row
	 * @param col the col
	 * @param turn the turn
	 * @return true, if successful
	 */
	public boolean accept(MVisitor visitor, int row, int col, char turn); //move
	
	/**
	 * Accept.
	 *
	 * @param visitor the visitor
	 * @param player the player
	 * @return the int
	 */
	public int accept(CVisitor visitor, char player); //count or mcount
	
	/**
	 * Accept.
	 *
	 * @param visitor the visitor
	 * @return the string
	 */
	public String accept(SVisitor visitor); //board string
	
	
}
