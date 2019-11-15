package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.util.Observable;

public class GreedyBehaviour implements moveStrategy {
	private MOthello mothello;
	private Othello othello;
	private String id;
	private PlayerGreedy playerGreedy;

	public GreedyBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		this.id = "AIBehaviour";
		playerGreedy = new PlayerGreedy(othello, OthelloBoard.P2);
	}

	public Move moveCommand() {
		return playerGreedy.getMove();
		
	}
	
	public String getId() {
		return this.id;
	}
	

}
