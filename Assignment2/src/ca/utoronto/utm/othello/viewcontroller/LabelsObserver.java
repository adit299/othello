package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;

public class LabelsObserver implements Observer {
	private Label hintLabel = new Label("No Hint First turn");//
	private Label winner = new Label();
	private Label whosNext = new Label("Current Turn: P1");
	private Label playerCount = new Label("Tokens (P1): 2    Tokens (P2): 2");
	private Label currentWinner = new Label("Current Winner: Tie");
	private Label player = new Label("P1: Human    P2: Human");

	@Override
	public void update(Observable o) {
		// TODO Auto-generated method stub
		
	}

}
