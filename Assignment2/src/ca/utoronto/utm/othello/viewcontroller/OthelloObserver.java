package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OthelloObserver implements EventHandler<ActionEvent>  {

	private Label lab;
	
	Othello othello=new Othello();
	
	public OthelloObserver(Label lab) {
		this.lab = lab;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.lab.setText(((Button)event.getSource()).getId());
		int row = ((Button)event.getSource()).getId().charAt(0) - 48;
		int col = ((Button)event.getSource()).getId().charAt(2) - 48;
//		System.out.println(othello.getBoardString()+ othello.getWhosTurn()+" moves next");
		if(othello.move(row, col)) {
			if (!(othello.isGameOver())) {
			((Button)event.getSource()).setText(String.valueOf(othello.getToken(row, col)));
//			System.out.println("makes move ("+row+","+col+")");
//			System.out.println(othello.getBoardString()+ othello.getWhosTurn()+" moves next");
//				if (((Button)event.getSource()).getId() == String.valueOf(row(event)) + ',' + String.valueOf(col(event))) {
//					
//				}
			}
//			else {
//				String s = othello.getBoardString() + othello.getWinner() + " won\n";
//				System.out.println(s);
//			}
		}
	}
	
//	public int row (ActionEvent event) {
//		return ((Button)event.getSource()).getId().charAt(0) - 48;
//	}
//	
//	public int col (ActionEvent event) {
//		return ((Button)event.getSource()).getId().charAt(2) - 48;
//	}
	
}

