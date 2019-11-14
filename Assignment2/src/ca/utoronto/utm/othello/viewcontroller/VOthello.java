package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;



public class VOthello implements Observer{
	
	private ArrayList<Button> buttons = new ArrayList<>();
	private ArrayList<Label> labels = new ArrayList<>();
	private Button HvH = new Button("HvH");
	private Button HvG = new Button("HvG");
	private Button HvR = new Button("HvR");
	
	private Label timerLabel = new Label("Time Remaining: 5:00");
	private CountDownTimer countDowntimer = new CountDownTimer(timerLabel);
	
	private TilePane tile = new TilePane(Orientation.HORIZONTAL);
	private Button hintButton = new Button("Hint");//
	private Label hintLabel = new Label("No Hint First turn");//
	private Label winner = new Label();
	private Label whosNext = new Label("Current Turn: X");
	private Label playerCount = new Label("Tokens (P1): 2    Tokens (P2): 2");
	private Label currentWinner = new Label("Current Winner: Tie");
	private Label player = new Label("P1: Human    P2: Human");
	
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
		timerLabel.setId("0,8");
		whosNext.setId("0,12");
		playerCount.setId("0,16");
		player.setId("0,20");
		currentWinner.setId("0,24");
		winner.setId("0,28");
		labels.addAll(Arrays.asList(winner, whosNext, playerCount, currentWinner, player, timerLabel));
		tile.setHgap(20);
		tile.getChildren().addAll(this.HvH, this.HvG, this.HvR);
		
		startTimer();

		}
		
		
		public void startTimer() {
		    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
		        countDowntimer.run();
		    }));
		    timeline.setCycleCount(Animation.INDEFINITE);
		    timeline.play();
		}
				
	
//	public ArrayList<Button> getPlayerChoiceButtons() {
//		ArrayList<Button> playerChoice =  new ArrayList<Button>(Arrays.asList(this.HvH, this.HvR, this.HvG));
//		return playerChoice;
//	}
	
	public Button getPlayerChoiceButtons() {
		return this.HvG;
	}
	
	
	public ArrayList<Button> getButtons() {
		return this.buttons;
	}
	
	public ArrayList<Label> getLabels(){
		return this.labels;
	}

	public Button getHintButton() {//
		return this.hintButton;
	}
	
	public Label getHintLabel() {//
		return this.hintLabel;
	}
	
	public TilePane getTile() {
		return this.tile;
	}
	
	public void setTimer() {
		countDowntimer.countDown();
		timerLabel.setText(countDowntimer.toString());
	}
	
	
	@Override
	public void update(Observable o) {
		MOthello mothello = (MOthello)o;
		countDowntimer.resetTimer();
		timerLabel.setText(countDowntimer.toString());
		if (mothello.getSText() == this.HvH.getText()) {
			this.player.setText("P1: Human    P2: Human");
		}
		else if (mothello.getSText() == this.HvG.getText()) {
			this.player.setText("P1: Human    P2: Greedy");
		}
		else if (mothello.getSText() == this.HvR.getText()) {
			this.player.setText("P1: Human    P2: Random");
		}
		
		if (!mothello.gameOver && mothello.getChange()) {
			this.whosNext.setText("Current Turn: " + String.valueOf(mothello.getWhosTurn()));
			this.playerCount.setText(mothello.playerCount());
			this.currentWinner.setText(mothello.currentWinner());
			this.hintLabel.setText(mothello.getHint());
			for (Button btn : this.buttons) {
				if (mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'X') {
					btn.setStyle("-fx-background-color:black");
				}
				else if ((mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'O')){
					btn.setStyle("-fx-background-color:white");
				}
			}
		}
		else if (mothello.gameOver) {
			this.winner.setText("GAME OVER: " + "PLAYER " + mothello.getWin() + " WINS!");
		}
	}
	
}
