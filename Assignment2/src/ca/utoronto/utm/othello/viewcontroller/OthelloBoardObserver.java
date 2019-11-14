package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Button;

public class OthelloBoardObserver implements Observer {
	private ArrayList<Button> buttons = new ArrayList<>();
	
	public OthelloBoardObserver() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Button btn = new Button();
				btn.setId(String.valueOf(row) + ',' + String.valueOf(col));
				buttons.add(btn);
			}
		}
	}
	@Override
	public void update(Observable o) {
		MOthello mothello = (MOthello)o;
		for (Button btn : this.buttons) {
			if (mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'X') {
				btn.setStyle("-fx-background-color:black");
			}
			else if ((mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48) == 'O')){
				btn.setStyle("-fx-background-color:white");
			}
		}
	}
		
}

