package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerStrategic;

public class StrategicBehaviour implements moveStrategy{
	private MOthello mothello;
	private Othello othello;
	private String id;
	private PlayerStrategic playerStrategic;

	public StrategicBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
		this.id = "AIBehaviour";
		playerStrategic = new PlayerStrategic(othello, OthelloBoard.P2);
	}

	public Move moveCommand() {
		return playerStrategic.getMove();
		
	}
	
	public String getId() {
		return this.id;
	}
	

}
