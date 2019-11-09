package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class VOthello implements Observer{
	
	private ArrayList<Button> buttons = new ArrayList<>();
	private Button hintButton = new Button("Hint");//
	private Label hintLabel = new Label("No Hint First turn");//
	private Label winner = new Label();
	private Label whosNext = new Label("Current Turn: X");
	private Label playerCount = new Label("Player 1: 2 Player 2: 2");
	private Label currentWinner = new Label("Tie");
	
	public VOthello() {
		hintButton.setId("hint");//
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Button btn = new Button();
				btn.setId(String.valueOf(row) + ',' + String.valueOf(col));
				buttons.add(btn);
				if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
					btn.setStyle("-fx-background-color:black");
				}
				else if ((row == 3 && col == 4) || (row == 4 && col ==3)) {
					btn.setStyle("-fx-background-color:white");
				}
			}
		}
	}
	
	public ArrayList<Button> getButtons() {
		return this.buttons;
	}
	
	public Button getHintButton() {//
		return this.hintButton;
	}
	
	public Label getHintLabel() {//
		return this.hintLabel;
	}
	
	public Label getWinner() {
		return this.winner;
	}
	
	public Label getWhosNext() {
		return this.whosNext;
	}
	
	public Label playerCount() {
		return this.playerCount;
	}
	
	public Label getCurrentWinner() {
		return this.currentWinner;
	}
	
	@Override
	public void update(Observable o) {
		MOthello mothello = (MOthello)o;
		if (!mothello.gameOver) {
			this.whosNext.setText("Current Turn: " + String.valueOf(mothello.getWhosTurn()));
			this.playerCount.setText(mothello.playerCount());
			this.currentWinner.setText(mothello.currentWinner());
			this.hintLabel.setText(mothello.getHint());
			
			int row = mothello.getStart().charAt(0) - 48;
			int col = mothello.getStart().charAt(2) - 48;
			for (Button btn : this.buttons) {
				if (!btn.getStyle().equals(null)){
					if (mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'X') {
						btn.setStyle("-fx-background-color:black");
					}
					else if ((mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'O')) {
						btn.setStyle("-fx-background-color:white");
					}		
				}
				if (btn.getId().charAt(0)-48 == row && btn.getId().charAt(2)-48 == col) {
					if (mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'X') {
						btn.setStyle("-fx-background-color:black");
					}
					else if ((mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'O')){
						btn.setStyle("-fx-background-color:white");
					}
				}
			}
		}
		else if (mothello.gameOver) {
			this.winner.setText("GAME OVER: " + "PLAYER " + mothello.getWin() + " WINS!");
		}
	}
	
}
