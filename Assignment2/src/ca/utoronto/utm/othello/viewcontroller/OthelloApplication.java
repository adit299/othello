package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Othello application is what creates and connects the othello mvc design
 * this class also takes the button and text field objects from VOthello
 * to form the content pane and window for user display
 *
 */
public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put 
	//	 --module-path "/usr/share/openjfx/lib" --add-modules javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.
	
	@Override
	/**
	 * this method constructs all the mvc components of the othello game and attaches them
	 * it also forms the window and content pane from parts from vothello
	 */
	public void start(Stage stage) throws Exception {
		
		//GAME
		Othello othello = new Othello();
		
		// MODEL
		MOthello mothello= new MOthello();
		
		// CONTROLLER
		// CONTROLLER->MODEL hookup
		Player2 player2 = new Player2(mothello, othello);
		COthello cothello=new COthello(mothello, othello, player2);
		
		
		// VIEW COMPONENTS && VIEW LAYOUT
		VOthello vothello = new VOthello();
		
		TimerButtonEventHandler tbHandler = new TimerButtonEventHandler(vothello.getCountDownTimerP1(), vothello.getCountDownTimerP2(), 
																		vothello.getMinutes(), vothello.getSeconds(), vothello.getp1Label(),
																		vothello.getp2Label());
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(2,2,2,2));
		
		//add all buttons
		for (Button button : vothello.getButtons()) {
			grid.add(button, button.getId().charAt(0), button.getId().charAt(2));
			button.setOnAction(cothello);
			button.setMinHeight(70);
			button.setPrefHeight(70);
			button.setMaxHeight(70);
			button.setMinWidth(70);
			button.setPrefWidth(70);
			button.setMaxWidth(70);
		}
				
		for (Button button : vothello.getPlayerChoiceButtons()) {
			button.setOnAction(player2);
		}
		
		vothello.getSubmitButton().setOnAction(tbHandler);
		vothello.getHintButton().setOnAction(cothello);
		
		//add all labels
		for (Label label : vothello.getLabels()) {
			grid.add(label, label.getId().charAt(0)-48, Integer.valueOf(label.getId().substring(2)));
		}
		
		for (TextField textfield : vothello.getTimerComponents()) {
			grid.add(textfield, textfield.getId().charAt(0)-48, Integer.valueOf(textfield.getId().substring(2)));
		}

		for (Node node : vothello.getTile().getChildren()) {
			node.setId("10,10");
			node.addEventHandler(ActionEvent.ACTION, cothello);
		}
		
		GridPane.setColumnSpan(vothello.getTile(), 10);
		grid.add(vothello.getTile(), 50, 16);
		grid.add(vothello.getHintButton(), 0, 28);
		grid.add(vothello.getHintLabel(), 0, 32);
		
		// SCENE
		Scene scene = new Scene(grid); 
		stage.setTitle("Othello");
		stage.setScene(scene);
		
		// VIEW
		// VIEW->CONTROLLER hookup
		// MODEL->VIEW hookup
		//mothello.attach(othello);
		mothello.attach(vothello);
		
		
		// LAUNCH THE GUI
		stage.show();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
