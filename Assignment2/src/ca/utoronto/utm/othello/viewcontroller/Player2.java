package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Player2 implements EventHandler<ActionEvent>{
	private Othello othello;
	private MOthello mothello;
	private GreedyBehaviour greedyBehaviour;
	private RandomBehaviour randomBehaviour;
	private HumanBehaviour humanBehaviour;
	
	moveStrategy strategy;
	
	
	public Player2(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		greedyBehaviour = new GreedyBehaviour(mothello, othello);
		randomBehaviour = new RandomBehaviour(mothello, othello);
		humanBehaviour = new HumanBehaviour();
		this.strategy = humanBehaviour;
	}


	@Override
	public void handle(ActionEvent event) {
		String id = ((Button)event.getSource()).getText();
		if (id == "HvR") {
			this.strategy = randomBehaviour;
			if (mothello.getWhosTurn() == OthelloBoard.P2) {
				Move randomMove = this.strategy.moveCommand();
				this.mothello.move(randomMove.getRow(), randomMove.getCol());
			}
		}
		else if (id == "HvG") {
			this.strategy = greedyBehaviour;
			if (mothello.getWhosTurn() == OthelloBoard.P2) {
				Move greedyMove = this.strategy.moveCommand();
				this.mothello.move(greedyMove.getRow(), greedyMove.getCol());
			}
		}
		else {
			this.strategy = humanBehaviour;
		}
		
	}		
}


