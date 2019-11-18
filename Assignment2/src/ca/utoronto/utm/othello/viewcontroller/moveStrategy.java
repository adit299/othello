package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;


/**
 * The Interface moveStrategy.
 */
public interface moveStrategy {
	
	/**
	 * Move command.
	 *
	 * @return the move
	 */
	public Move moveCommand();
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId();
	
}
