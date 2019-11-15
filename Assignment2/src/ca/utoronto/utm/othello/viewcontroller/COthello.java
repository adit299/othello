package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class COthello implements EventHandler<ActionEvent>  {

	private Othello othello;
	private MOthello mothello;
	private Player2 player2;
	
	public COthello(MOthello mothello, Othello othello, Player2 player2) {
		this.othello = othello;
		this.mothello = mothello;
		this.player2 = player2;
	}

	public void handle(ActionEvent event) {//
		String id = ((Button)event.getSource()).getId();
		if (id.equals("hint")) {
			if (!(this.othello.isGameOver()) && (this.mothello.hintAvailable())) {
				mothello.updateHint();
			}
		}else if (((Button)event.getSource()).getParent() instanceof TilePane) {
				mothello.cPlayer(this.othello, ((Button)event.getSource()).getText());
		}
		else {
			int row = id.charAt(0) - 48;
			int col = id.charAt(2) - 48;
			
			if(this.othello.move(row, col)) {
				if (!(this.othello.isGameOver())) {
					mothello.resetHint();
					mothello.player(this.othello, ((Button)event.getSource()).getId());
					if (this.player2.strategy.getId() == "AIBehaviour") {
						Move Player2Move = this.player2.strategy.moveCommand();
						mothello.move(Player2Move.getRow(), Player2Move.getCol());
					}
				}
				else {
					mothello.gameOver();
				}
			}			
		}
	}	
}


