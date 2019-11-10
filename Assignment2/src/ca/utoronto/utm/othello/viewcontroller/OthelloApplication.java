package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put 
	//	 --module-path "/usr/share/openjfx/lib" --add-modules javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//GAME
		Othello othello = new Othello();
		
		// MODEL
		MOthello mothello= new MOthello();
		
		// CONTROLLER
		// CONTROLLER->MODEL hookup
		COthello cothello=new COthello(mothello, othello);
		PlayerChangeEventHandler peventhandler = new PlayerChangeEventHandler(); 
		
		// VIEW COMPONENTS && VIEW LAYOUT
		VOthello vothello = new VOthello();
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(2,2,2,2));
		
		//add all buttons
		for (Button button : vothello.getButtons()) {
			grid.add(button, button.getId().charAt(0), button.getId().charAt(2));
			button.setOnAction(cothello);
			button.setMinHeight(75);
			button.setPrefHeight(75);
			button.setMaxHeight(75);
			button.setMinWidth(75);
			button.setPrefWidth(75);
			button.setMaxWidth(75);
		}
		
		for (Button button: vothello.getPlayerChoiceButtons()) {
			button.setOnAction(peventhandler);
			
		}
		
		vothello.getHintButton().setOnAction(cothello);
		
		//add all labels
		for (Label label : vothello.getLabels()) {
			grid.add(label, label.getId().charAt(0)-48, Integer.valueOf(label.getId().substring(2)));
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
		mothello.attach(vothello);
		
		// LAUNCH THE GUI
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
