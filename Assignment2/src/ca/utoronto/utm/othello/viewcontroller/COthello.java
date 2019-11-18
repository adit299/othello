package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
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
		}else if (((Button)event.getSource()).getParent() instanceof TilePane) {
			String btext = ((Button)event.getSource()).getText();
			if (btext.equals("HvR") || btext.equals("HvG") || btext.equals("HvH")) {
				mothello.player(this.othello, btext);
			}
			else {
				if (btext.equals("Undo")) {
					mothello.addCommand(new UndoCommand(this.othello, mothello.getAI()));   //undo command
					mothello.operate();
					mothello.player(this.othello, btext);
				}
				else if (btext.equals("Restart")){
					mothello.resetGame();
					mothello.addCommand(new RestartCommand(this.othello)); //restart command
					mothello.operate();
					mothello.player(this.othello, btext);
				}
			}
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


