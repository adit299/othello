package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class VOthello implements Observer{
	
	private ArrayList<Button> buttons = new ArrayList<>();
	private Label winner = new Label();
	private Label whosNext = new Label("Current Turn: X");
	private Label playerCount = new Label("Player 1: 2 Player 2: 2");
	private Label currentWinner = new Label("Tie");
	
	public VOthello() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Button btn = new Button();
				btn.setId(String.valueOf(row) + ',' + String.valueOf(col));
				buttons.add(btn);
				if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
					btn.setText(String.valueOf('X'));
				}
				else if ((row == 3 && col == 4) || (row == 4 && col ==3)) {
					btn.setText(String.valueOf('O'));
				}
			}
		}
	}
	
	public ArrayList<Button> getButtons() {
		return this.buttons;
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
			int row = mothello.getStart().charAt(0) - 48;
			int col = mothello.getStart().charAt(2) - 48;
			for (Button btn : this.buttons) {
				if (!btn.getText().isEmpty()){
					btn.setText(String.valueOf(mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48)));
				}
				if (btn.getId().charAt(0)-48 == row && btn.getId().charAt(2)-48 == col) {
					btn.setText(String.valueOf(mothello.getToken(row, col)));
				}
			}
		}
		else if (mothello.gameOver) {
			this.winner.setText("GAME OVER: " + "PLAYER " + mothello.getWin() + " WINS!");
		}
	}
	
}
