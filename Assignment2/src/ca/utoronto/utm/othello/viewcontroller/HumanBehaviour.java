package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;

/**
 * The Class HumanBehaviour.
 */
public class HumanBehaviour implements moveStrategy {
	
	/** The id. */
	private String id;
	
	/**
	 * Instantiates a new human behaviour.
	 */
	public HumanBehaviour() {
		this.id = "HumanBehaviour";
	}
	
	/**
	 * Move command.
	 *
	 * @return the move
	 */
	public Move moveCommand() {
		return null;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

}
