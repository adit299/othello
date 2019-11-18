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

/**
 * controller for the othello game, when user interacts with buttons on the window pane
 * they are all connected to the implemented handle in this class, which update
 * variables in the MOthello class so that for example, a player makes a move, that move is
 * sent through MOthello to be processed and turned into a graphical update so the players
 * turn actually is made
 */
public class COthello implements EventHandler<ActionEvent> {

	/** The othello. */
	private Othello othello;
	
	/** The mothello. */
	private MOthello mothello;
	
	/** The player 2. */
	private Player2 player2;
	
	/**
	 * constructor for COthello
	 * @param MOthello, is the attached model so it can update its variables when actions are performed
	 * @param Othello, the game that COthello will use to make calculations or decisions
	 * such as whether to continue processing actions when the game is already over
	 * @param player2 the second players play type, to determine if player 2 is ai or human and if
	 * actions performed is considered just a player 1 move
	 */
	public COthello(MOthello mothello, Othello othello, Player2 player2) {
		this.othello = othello;
		this.mothello = mothello;
		this.player2 = player2;
	}
	
	/**
	 * this only applies to player 2, this method is run every time a player
	 * makes a move to check whether its player 2's turn and whether they
	 * are an AI so that the ai will automatically make a move as player 2
	 */
	public void makeMove() {
		if (this.player2.strategy.getId() == "AIBehaviour") {
			Move Player2Move = this.player2.strategy.moveCommand();
			if(this.othello.move(Player2Move.getRow(), Player2Move.getCol())) {
				mothello.move(Player2Move.getRow(), Player2Move.getCol());
			}
			if (this.othello.isGameOver() || this.othello.getPossibleMoves().isEmpty()) {
				mothello.gameOver();
			}
		}
	}
	
	/**
	 * all buttons from VOthello are attached to this method as this is the method that
	 * allows players to update the game through moves or ai buttons
	 */
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


