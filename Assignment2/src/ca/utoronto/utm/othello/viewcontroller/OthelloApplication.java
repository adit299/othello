package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put 
	//	 --module-path "/usr/share/openjfx/lib" --add-modules javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.
	
	@Override
	public void start(Stage stage) throws Exception {
		// Create and hook up the Model, View and the controller
		CButtonPressEventHandler cbhandler;
		
		// MODEL
		Othello othello=new Othello();
		
		// CONTROLLER
		// CONTROLLER->MODEL hookup
	
		// VIEW
		// VIEW->CONTROLLER hookup
		// MODEL->VIEW hookup
		
		// VIEW COMPONENTS
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5));
		
		Label lab = new Label();
		grid.add(lab, 0, 8);
		cbhandler = new CButtonPressEventHandler(lab);
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Button but = new Button(" ");
				but.setId(String.valueOf(row) + ',' + String.valueOf(col));
				but.setOnAction(cbhandler);
				grid.add(but, col, row);
			}
		}
		
		
		// SCENE
		Scene scene = new Scene(grid); 
		stage.setTitle("Othello");
		stage.setScene(scene);
				
		// LAUNCH THE GUI
		stage.show();
	}

	public static void main(String[] args) {
		OthelloApplication view = new OthelloApplication();
		launch(args);
	}
}
