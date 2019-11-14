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
	private PlayerGreedy playerGreedy = new PlayerGreedy(othello, OthelloBoard.P2);
	public GreedyBehaviour greedyBehaviour = new GreedyBehaviour(mothello, othello);
	moveStrategy strategy;
	
	
	public Player2(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
	}


	@Override
	public void handle(ActionEvent event) {
		String id = ((Button)event.getSource()).getText();
		if (id == "HvR") {
//			RandomBehaviour randomBehaviour = new RandomBehaviour(mothello);
//			this.strategy = randomBehaviour;
		}
		else if (id == "HvG") {
//			System.out.println("Clicked");
//			System.out.println("" + playerGreedy.getMove().getRow() + "," + playerGreedy.getMove().getCol());
			this.strategy = greedyBehaviour;
			Move greedyMove = this.strategy.moveCommand();
			if(this.othello.move(2, 3)) {
				if(this.mothello.getWhosTurn() == OthelloBoard.P2) {
					mothello.move(2, 3);
				}
			}
		}		
	}

}
