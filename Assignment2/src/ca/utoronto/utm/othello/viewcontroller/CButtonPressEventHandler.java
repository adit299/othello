package ca.utoronto.utm.othello.viewcontroller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CButtonPressEventHandler implements EventHandler<ActionEvent>  {

	private Label lab;
	public CButtonPressEventHandler(Label lab) {
		this.lab = lab;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.lab.setText(((Button)event.getSource()).getId());
	}
	
	public String getId(ActionEvent event) {
		return ((Button) event.getSource()).getId();
	}
}

