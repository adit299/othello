package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;
import java.util.Arrays;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LabelsObserver implements Observer {
		private Button HvH = new Button("HvH");
		private Button HvG = new Button("HvG");
		private Button HvR = new Button("HvR");
		private Button HvS = new Button("HvS");
		private Label hintLabel = new Label("No Hint First turn");//
		private Label winner = new Label();
		private Label whosNext = new Label("Current Turn: P1");
		private Label playerCount = new Label("Tokens (P1): 2    Tokens (P2): 2");
		private Label currentWinner = new Label("Current Winner: Tie");
		private Label player = new Label("P1: Human    P2: Human");
		private ArrayList<Label> labels = new ArrayList<>();
	
		public LabelsObserver() {
			this.whosNext.setId("0,12");
			this.playerCount.setId("0,14");
			this.player.setId("0,16");
			this.currentWinner.setId("0,18");
			this.winner.setId("5,8");
			this.labels.addAll(Arrays.asList(winner, whosNext, playerCount, currentWinner, player));
		}
		
		public ArrayList<Label> getLabels() {
			return this.labels;
		}
		
		
		public void update(Observable o) {
			MOthello mothello = (MOthello)o;
			this.whosNext.setText("Current Turn: " + String.valueOf(mothello.getWhosTurn()));
			this.playerCount.setText(mothello.playerCount());
			this.currentWinner.setText(mothello.currentWinner());
			this.hintLabel.setText(mothello.getHint());
			
			if (mothello.getStart().equals(this.HvH.getText())) {
				this.player.setText("P1: Human    P2: Human");
			}
			else if (mothello.getStart().equals(this.HvG.getText())) {
				this.player.setText("P1: Human    P2: Greedy");
			}
			else if (mothello.getStart().equals(this.HvR.getText())) {
				this.player.setText("P1: Human    P2: Random");
			}
			else if (mothello.getStart().equals(this.HvS.getText())) {
				this.player.setText("P1: Human    P2: Strategic");
			}
			if (mothello.gameOver) {
				this.winner.setText("GAME OVER: " + "PLAYER " + mothello.getWin() + " WINS!");
				this.currentWinner.setText("GAME OVER");
			}
			
		}
}
