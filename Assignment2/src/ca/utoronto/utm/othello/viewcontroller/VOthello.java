package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class VOthello implements Observer{

	private ArrayList<Button> buttons = new ArrayList<>();
	private Label lab = new Label();
	
	public VOthello() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Button btn = new Button();
				btn.setId(String.valueOf(row) + ',' + String.valueOf(col));
				buttons.add(btn);
				if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
					btn.setText(String.valueOf('X'));
				}
				else if ((row == 3 && col == 4) || (row == 4 && col ==3)) {
					btn.setText(String.valueOf('O'));
				}
			}
		}
	}
	
	public ArrayList<Button> getButtons() {
		return this.buttons;
	}
	
	public Label getLabel() {
		return this.lab;
	}
	
	@Override
	public void update(Observable o) {
		MOthello mothello = (MOthello)o;
		if (!mothello.gameOver) {
			int row = mothello.getStart().charAt(0) - 48;
			int col = mothello.getStart().charAt(2) - 48;
			for (Button btn : this.buttons) {
				if (!btn.getText().isEmpty()){
					btn.setText(String.valueOf(mothello.getToken(btn.getId().charAt(0)-48, btn.getId().charAt(2)-48)));
				}
				if (btn.getId().charAt(0)-48 == row && btn.getId().charAt(2)-48 == col) {
					btn.setText(String.valueOf(mothello.getToken(row, col)));
				}
			}
		}
		else if (mothello.gameOver) {
			this.lab.setText("GAME OVER: " + "PLAYER " + mothello.getWin() + " WINS!");
		}
	}
	
}
