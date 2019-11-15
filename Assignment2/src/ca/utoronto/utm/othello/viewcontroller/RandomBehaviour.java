package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerRandom;


public class RandomBehaviour implements moveStrategy {
	private MOthello mothello;
	private Othello othello;
	private String id;
	private PlayerRandom playerRandom;

	public RandomBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		this.id = "AIBehaviour";
		playerRandom = new PlayerRandom(othello, OthelloBoard.P2);
	}

	public Move moveCommand() {
		return playerRandom.getMove();
		
	}
	
	public String getId() {
		return this.id;
	}

}
