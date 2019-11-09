package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class COthello implements EventHandler<ActionEvent>  {

	private Othello othello;
	private MOthello mothello;
	public COthello(MOthello mothello, Othello othello) {
		this.othello = othello;
		this.mothello = mothello;
	}
	
	@Override
	public void handle(ActionEvent event) {//
		String id = ((Button)event.getSource()).getId();
		if (id.equals("hint")) {
			if (!(this.othello.isGameOver()) && (this.mothello.hintAvailable())) {
				mothello.updateHint();
			}
		}else {
			int row = id.charAt(0) - 48;
			int col = id.charAt(2) - 48;
			if(this.othello.move(row, col)) {
				if (!(this.othello.isGameOver())) {
					mothello.player(this.othello, ((Button)event.getSource()).getId());
				}
				else {
					mothello.gameOver();
				}
			}			
		}
	}	
}

