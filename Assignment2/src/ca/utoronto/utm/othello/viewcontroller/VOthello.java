package ca.utoronto.utm.othello.viewcontroller;

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
	
	/** The buttons. */
	private ArrayList<Button> buttons = new ArrayList<>();
	
	/** The labels. */
	private ArrayList<Label> labels = new ArrayList<>();
	
	/** The HvH button. */
	private Button HvH = new Button("HvH");
	
	/** The HvG button. */
	private Button HvG = new Button("HvG");
	
	/** The HvR button. */
	private Button HvR = new Button("HvR");
	
	/** The HvS button. */
	private Button HvS = new Button("HvS");
	
	/** The Restart. */
	private Button Restart = new Button ("Restart");
	
	/** The Undo. */
	private Button Undo = new Button ("Undo");
	
	/** The minutes. */
	private TextField minutes = new TextField("Enter Minutes here");
	
	/** The seconds. */
	private TextField seconds = new TextField("Enter Seconds here");
	
	/** The submit. */
	private Button submit = new Button ("Set Time");
	
	
	
	/** The P1 label. */
	private Label P1Label = new Label("P1 Time Remaining: 5:00");
	
	/** The P1 countdown timer. */
	private CountDownTimer P1countDowntimer = new CountDownTimer(P1Label, "P1");
	
	/** The P2 label. */
	private Label P2Label = new Label("P2 Time Remaining: 5:00");
	
	/** The P2 countdown timer. */
	private CountDownTimer P2countDowntimer = new CountDownTimer(P2Label, "P2");
	
	
	
	/** The P1 timer. */
	private Timeline P1timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        P1countDowntimer.run();
    }));
	
	/** The P2 timer. */
	private Timeline P2timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        P2countDowntimer.run();
    }));
	
	
	
	/** The tile. */
	private TilePane tile = new TilePane(Orientation.HORIZONTAL);
	
	/** The hint button. */
	private Button hintButton = new Button("Hint");//
	
	/** The hint label. */
	private Label hintLabel = new Label("No Hint First turn");//
	
	/** The winner. */
	private Label winner = new Label();
	
	/** The whos next. */
	private Label whosNext = new Label("Current Turn: P1");
	
	/** The player count. */
	private Label playerCount = new Label("Tokens (P1): 2    Tokens (P2): 2");
	
	/** The current winner. */
	private Label currentWinner = new Label("Current Winner: Tie");
	
	/** The player. */
	private Label player = new Label("P1: Human    P2: Human");
	
	/**
	 * Instantiates a new VOthello.
	 * Creates all of the buttons and labels in the view. 
	 */
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
		tile.getChildren().addAll(this.submit, this.HvH, this.HvG, this.HvR, this.HvS, this.Restart, this.Undo);
		
		
		this.P1timer.setCycleCount(Animation.INDEFINITE);
		this.P2timer.setCycleCount(Animation.INDEFINITE);	
		}
				
	
	/**
	 * Gets the player choice buttons (HvH, HvR, HvG, HvS).
	 *
	 * @return the player choice buttons
	 */
	public ArrayList<Button> getPlayerChoiceButtons() {
		ArrayList<Button> playerChoice =  new ArrayList<Button>(Arrays.asList(this.HvH, this.HvR, this.HvG,this.HvS));
		return playerChoice;
	}
	
	/**
	 * Gets the count down timer P1.
	 *
	 * @return the count down timer P1
	 */
	public CountDownTimer getCountDownTimerP1() {
		return this.P1countDowntimer;
	}
	
	/**
	 * Gets the count down timer P2.
	 *
	 * @return the count down timer P2
	 */
	public CountDownTimer getCountDownTimerP2() {
		return this.P2countDowntimer;
	}
	
	/**
	 * Gets the minutes.
	 *
	 * @return the minutes
	 */
	public TextField getMinutes() {
		return this.minutes;
	}
	
	/**
	 * Gets the seconds.
	 *
	 * @return the seconds
	 */
	public TextField getSeconds() {
		return this.seconds;
	}
	
	/**
	 * Gets the submit button.
	 *
	 * @return the submit button
	 */
	public Button getSubmitButton() {
		return this.submit;
	}
	
	/**
	 * Gets the p1 label.
	 *
	 * @return the p1 label
	 */
	public Label getp1Label() {
		return this.P1Label;
	}
	
	/**
	 * Gets the p2 label.
	 *
	 * @return the p2 label
	 */
	public Label getp2Label() {
		return this.P2Label;
	}
	
	
	/**
	 * Gets the timer components.
	 *
	 * @return the timer components
	 */
	public ArrayList<TextField> getTimerComponents() {
		ArrayList<TextField> timerComponents = new ArrayList<TextField>(Arrays.asList(this.minutes, this.seconds));
		return timerComponents;
	}
	
	/**
	 * Gets the buttons.
	 *
	 * @return the buttons
	 */
	public ArrayList<Button> getButtons() {
		return this.buttons;
	}
	
	/**
	 * Gets the labels.
	 *
	 * @return the labels
	 */
	public ArrayList<Label> getLabels(){
		return this.labels;
	}

	/**
	 * Gets the hint button.
	 *
	 * @return the hint button
	 */
	public Button getHintButton() {//
		return this.hintButton;
	}
	
	/**
	 * Gets the hint label.
	 *
	 * @return the hint label
	 */
	public Label getHintLabel() {//
		return this.hintLabel;
	}
	
	/**
	 * Gets the tile.
	 *
	 * @return the tile
	 */
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
		else if (mothello.getStart().equals(this.HvS.getText())) {
			this.player.setText("P1: Human    P2: Strategic");
		}
		else if (mothello.getStart().equals(this.Restart.getText())) {
			for (Button btn : this.buttons) {
				btn.setStyle(null);
			}
			this.winner.setText("");
			this.P1countDowntimer.resetTimer();
			this.P2countDowntimer.resetTimer();
			this.P1Label.setText("P1 Time Remaining: 5:00");
			this.P2Label.setText("P2 Time Remaining: 5:00");
			this.P1timer.stop();
			this.P2timer.stop();
			this.currentWinner.setText(mothello.currentWinner());
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
			
			ArrayList<String> coord = mothello.getHighlightBoard();
			this.whosNext.setText("Current Turn: " + String.valueOf(mothello.getWhosTurn()));
			this.playerCount.setText(mothello.playerCount());
			this.currentWinner.setText(mothello.currentWinner());
			this.hintLabel.setText(mothello.getHint());
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
				
				if (mothello.getWhosTurn() == "P1") {
					btn.setDisable(false);
				}else if (mothello.getWhosTurn() == "P2" && mothello.getAI()) {
					btn.setDisable(true);
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
