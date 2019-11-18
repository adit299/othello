package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.util.Observable;


/**
 * The Class GreedyBehaviour.
 */
public class GreedyBehaviour implements moveStrategy {
	
	/** The mothello. */
	private MOthello mothello;
	
	/** The othello. */
	private Othello othello;
	
	/** The id. */
	private String id;
	
	/** The player greedy. */
	private PlayerGreedy playerGreedy;

	/**
	 * Instantiates a new greedy behaviour.
	 *
	 * @param mothello the mothello
	 * @param othello the othello
	 */
	public GreedyBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		this.id = "AIBehaviour";
		playerGreedy = new PlayerGreedy(othello, OthelloBoard.P2);
	}

	/**
	 * Move command.
	 *
	 * @return the move
	 */
	public Move moveCommand() {
		return playerGreedy.getMove();
		
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
