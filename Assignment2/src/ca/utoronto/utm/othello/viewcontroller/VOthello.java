package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;


import java.util.ArrayList;
import java.util.Arrays;



public class VOthello implements Observer{
	
	private ArrayList<Button> buttons = new ArrayList<>();
	private ArrayList<Label> labels = new ArrayList<>();
	
	private Button HvH = new Button("HvH");
	private Button HvG = new Button("HvG");
	private Button HvR = new Button("HvR");
	
	private Button Restart = new Button ("Restart");
	private Button Undo = new Button ("Undo");
	
	private TextField minutes = new TextField("Enter Minutes here");
	private TextField seconds = new TextField("Enter Seconds here");
	private Button submit = new Button ("Set Time");
	
	
	
	private Label P1Label = new Label("P1 Time Remaining: 5:00");
	private CountDownTimer P1countDowntimer = new CountDownTimer(P1Label, "P1");
	private Label P2Label = new Label("P2 Time Remaining: 5:00");
	private CountDownTimer P2countDowntimer = new CountDownTimer(P2Label, "P2");
	
	
	
	private Timeline P1timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        P1countDowntimer.run();
    }));
	private Timeline P2timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        P2countDowntimer.run();
    }));
	
	
	
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
		
		P1Label.setId("0,8");
		P2Label.setId("0,10");
		whosNext.setId("0,12");
		playerCount.setId("0,14");
		player.setId("0,16");
		currentWinner.setId("0,18");
		winner.setId("5,8");
		minutes.setId("8,8");
		seconds.setId("9,8");
		
		labels.addAll(Arrays.asList(winner, whosNext, playerCount, currentWinner, player, P1Label, P2Label));
		tile.setHgap(10);
		tile.getChildren().addAll(this.submit, this.HvH, this.HvG, this.HvR, this.Restart, this.Undo);
		
		
		this.P1timer.setCycleCount(Animation.INDEFINITE);
		this.P2timer.setCycleCount(Animation.INDEFINITE);	
		}
				
	
	public ArrayList<Button> getPlayerChoiceButtons() {
		ArrayList<Button> playerChoice =  new ArrayList<Button>(Arrays.asList(this.HvH, this.HvR, this.HvG));
		return playerChoice;
	}
	
	public CountDownTimer getCountDownTimerP1() {
		return this.P1countDowntimer;
	}
	
	public CountDownTimer getCountDownTimerP2() {
		return this.P2countDowntimer;
	}
	
	public TextField getMinutes() {
		return this.minutes;
	}
	
	public TextField getSeconds() {
		return this.seconds;
	}
	
	public Button getSubmitButton() {
		return this.submit;
	}
	
	public Label getp1Label() {
		return this.P1Label;
	}
	
	public Label getp2Label() {
		return this.P2Label;
	}
	
	
	public ArrayList<TextField> getTimerComponents() {
		ArrayList<TextField> timerComponents = new ArrayList<TextField>(Arrays.asList(this.minutes, this.seconds));
		return timerComponents;
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
	
	
	
	@Override
	public void update(Observable o) {
		MOthello mothello = (MOthello)o;
		
		if (mothello.getStart().equals(this.HvH.getText())) {
			this.player.setText("P1: Human    P2: Human");
		}
		else if (mothello.getStart().equals(this.HvG.getText())) {
			this.player.setText("P1: Human    P2: Greedy");
		}
		else if (mothello.getStart().equals(this.HvR.getText())) {
			this.player.setText("P1: Human    P2: Random");
		}
		else if (mothello.getStart().equals(this.Restart.getText())) {
			for (Button btn : this.buttons) {
				btn.setStyle(null);
			}
		}
		else if (mothello.getStart().equals(this.Undo.getText())) {
			for (Button btn : this.buttons) {
				if (mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'X') {
					btn.setStyle("-fx-background-color:black");
				}
				else if ((mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'O')){
					btn.setStyle("-fx-background-color:white");
				}
				else {
					btn.setStyle(null);
				}
			}
		}
		
		if (!mothello.gameOver && mothello.getChange()) {
			if (mothello.getWhosTurn() == "P2") {
				this.P1timer.stop();
				this.P2timer.play();
			}
			else if (mothello.getWhosTurn() == "P1") {
				this.P2timer.stop();
				this.P1timer.play();
			}
			
			
			this.whosNext.setText("Current Turn: " + String.valueOf(mothello.getWhosTurn()));
			this.playerCount.setText(mothello.playerCount());
			this.currentWinner.setText(mothello.currentWinner());
			this.hintLabel.setText(mothello.getHint());
			ArrayList<String> coord = mothello.getHighlightBoard();
			for (Button btn : this.buttons) {
				if (mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'X') {
					btn.setStyle("-fx-background-color:black");
				}else if ((mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'O')){
					btn.setStyle("-fx-background-color:white");
				}else if (coord.contains((btn.getId().charAt(0)-48)+","+(btn.getId().charAt(2)-48))) {
					btn.setStyle("-fx-background-color:green");
				}else {
					btn.setStyle(null);
				}
			}
		}
		else if (mothello.gameOver) {
			this.P1timer.stop();
			this.P2timer.stop();
			this.winner.setText("GAME OVER: " + "PLAYER " + mothello.getWin() + " WINS!");
			this.currentWinner.setText("GAME OVER");
		}
	}
	
}
