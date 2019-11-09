package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
		
		// VIEW COMPONENTS && VIEW LAYOUT
		VOthello vothello = new VOthello();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(2,2,2,2));
		
		for (Button button : vothello.getButtons()) {
			grid.add(button, button.getId().charAt(2), button.getId().charAt(0));
			button.setOnAction(cothello);
			button.setMinWidth(50);
			button.setPrefWidth(50);
			button.setMaxWidth(50);
		}
		vothello.getHintButton().setOnAction(cothello);
		
		grid.add(vothello.getWinner(), 0, 8);
		grid.add(vothello.getWhosNext(), 0, 12);
		grid.add(vothello.playerCount(), 0, 16);
		grid.add(vothello.getCurrentWinner(), 0, 20);
		grid.add(vothello.getHintButton(), 0, 24);//
		grid.add(vothello.getHintLabel(), 0, 28);//
		
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
