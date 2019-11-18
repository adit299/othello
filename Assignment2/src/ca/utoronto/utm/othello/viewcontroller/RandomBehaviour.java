package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerRandom;

/**
 * The Class RandomBehaviour.
 */
public class RandomBehaviour implements moveStrategy {
	
	/** The mothello. */
	private MOthello mothello;
	
	/** The othello. */
	private Othello othello;
	
	/** The id. */
	private String id;
	
	/** The player random. */
	private PlayerRandom playerRandom;

	/**
	 * Instantiates a new random behaviour.
	 *
	 * @param mothello the mothello
	 * @param othello the othello
	 */
	public RandomBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		this.id = "AIBehaviour";
		playerRandom = new PlayerRandom(othello, OthelloBoard.P2);
	}

	/**
	 * Move command.
	 *
	 * @return the move
	 */
	public Move moveCommand() {
		return playerRandom.getMove();
		
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
