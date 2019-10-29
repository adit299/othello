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
		System.out.println(othello.getBoardString()+ othello.getWhosTurn()+" moves next");
		if(othello.move(row(event), col(event))) {
			System.out.println("makes move ("+row(event)+","+col(event)+")");
			System.out.println(othello.getBoardString()+ othello.getWhosTurn()+" moves next");
		}	
	}
	
	public int row (ActionEvent event) {
		return ((Button)event.getSource()).getId().charAt(0) - 48;
	}
	
	public int col (ActionEvent event) {
		return ((Button)event.getSource()).getId().charAt(2) - 48;
	}
	
}

