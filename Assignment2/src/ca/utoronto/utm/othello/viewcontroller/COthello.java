package ca.utoronto.utm.othello.viewcontroller;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

public class COthello implements EventHandler<ActionEvent> {

	private Othello othello;
	private MOthello mothello;
	private Player2 player2;
	
	public COthello(MOthello mothello, Othello othello, Player2 player2) {
		this.othello = othello;
		this.mothello = mothello;
		this.player2 = player2;
	}
	
	public void makeMove() {
		if (this.player2.strategy.getId() == "AIBehaviour") {
			Move Player2Move = this.player2.strategy.moveCommand();
			if(this.othello.move(Player2Move.getRow(), Player2Move.getCol())) {
				mothello.move(Player2Move.getRow(), Player2Move.getCol());
			}
			else if (this.othello.isGameOver()) {
				mothello.gameOver();
			}
		}
	}
	

	public void handle(ActionEvent event) {//
		String id = ((Button)event.getSource()).getId();
		if (id.equals("hint")) {
			if (!(this.othello.isGameOver()) && (this.mothello.hintAvailable())) {
				mothello.updateHint();
			}
		}else if (((Button)event.getSource()).getParent() instanceof TilePane || ((Button)event.getSource()).getText().equals("Restart")) {
				mothello.player(this.othello, ((Button)event.getSource()).getText());
		}
		else {
			int row = id.charAt(0) - 48;
			int col = id.charAt(2) - 48;
			
			if(this.othello.move(row, col)) {
				if (!(this.othello.isGameOver())) {
					mothello.resetHint();
					mothello.player(this.othello, ((Button)event.getSource()).getId());
					Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
						makeMove();
					}));
					timeline.play();
					
				}
				else {
					mothello.player(this.othello, ((Button)event.getSource()).getId());
					mothello.gameOver();
				}
				
			}
		}
	}
}


