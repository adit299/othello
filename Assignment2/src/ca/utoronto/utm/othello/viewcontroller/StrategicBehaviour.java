package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerStrategic;


/**
 * The Class StrategicBehaviour.
 */
public class StrategicBehaviour implements moveStrategy{
	
	/** The mothello. */
	private MOthello mothello;
	
	/** The othello. */
	private Othello othello;
	
	/** The id. */
	private String id;
	
	/** The player strategic. */
	private PlayerStrategic playerStrategic;

	/**
	 * Instantiates a new strategic behaviour.
	 *
	 * @param mothello the mothello
	 * @param othello the othello
	 */
	public StrategicBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		this.id = "AIBehaviour";
		playerStrategic = new PlayerStrategic(othello, OthelloBoard.P2);
	}

	/**
	 * Move command.
	 *
	 * @return the move
	 */
	public Move moveCommand() {
		return playerStrategic.getMove();
		
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
