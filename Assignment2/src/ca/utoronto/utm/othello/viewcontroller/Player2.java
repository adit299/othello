package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**
 * The Class Player2.
 */
public class Player2 implements EventHandler<ActionEvent>{
	
	/** The othello. */
	private Othello othello;
	
	/** The mothello. */
	private MOthello mothello;
	
	/** The greedy behaviour. */
	private GreedyBehaviour greedyBehaviour;
	
	/** The random behaviour. */
	private RandomBehaviour randomBehaviour;
	
	/** The human behaviour. */
	private HumanBehaviour humanBehaviour;
	
	/** The strategic behaviour. */
	private StrategicBehaviour strategicBehaviour;
	
	/** The strategy. */
	moveStrategy strategy;
	
	
	/**
	 * Instantiates a new player 2.
	 *
	 * @param mothello the mothello
	 * @param othello the othello
	 */
	public Player2(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		greedyBehaviour = new GreedyBehaviour(mothello, othello);
		randomBehaviour = new RandomBehaviour(mothello, othello);
		strategicBehaviour = new StrategicBehaviour(mothello, othello);
		humanBehaviour = new HumanBehaviour();
		this.strategy = humanBehaviour;
	}


	/**
	 * Handle.
	 *
	 * @param event the event
	 */
	@Override
	public void handle(ActionEvent event) {
		String id = ((Button)event.getSource()).getText();
		if (id == "HvR") {
			this.strategy = randomBehaviour;
			mothello.AICheck("AI");
			if (mothello.getWhosTurn() == "P2") {			
				Move randomMove = this.strategy.moveCommand();
				this.mothello.move(randomMove.getRow(), randomMove.getCol());
			}
		}
		else if (id == "HvG") {
			this.strategy = greedyBehaviour;
			mothello.AICheck("AI");
			if (mothello.getWhosTurn() == "P2") {
				Move greedyMove = this.strategy.moveCommand();
				this.mothello.move(greedyMove.getRow(), greedyMove.getCol());
			}
		}
		else if (id == "HvS") {
			this.strategy = strategicBehaviour;
			mothello.AICheck("AI");
			if (mothello.getWhosTurn() == "P2") {
				Move strategicMove = this.strategy.moveCommand();
				this.mothello.move(strategicMove.getRow(), strategicMove.getCol());
			}
		}
		else {
			mothello.AICheck("H");
			this.strategy = humanBehaviour;
		}
		
	}		
}



