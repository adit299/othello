package ca.utoronto.utm.othello.viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TimerButtonEventHandler implements EventHandler<ActionEvent> {
	
	private TextField minutes;
	private TextField seconds;
	private Label P1Label = new Label("P1 Time Remaining: ");
	private Label P2Label = new Label("P2 Time Remaining: ");
	private CountDownTimer P1countDowntimer;
	private CountDownTimer P2countDowntimer;
	
	
	

	public TimerButtonEventHandler(CountDownTimer countDownTimerP1, CountDownTimer countDownTimerP2, 
			TextField minutes, TextField seconds, Label P1Label, Label P2Label) {
		this.P1countDowntimer = countDownTimerP1;
		this.P2countDowntimer = countDownTimerP2;
		this.minutes = minutes;
		this.seconds = seconds;
		this.P1Label = P1Label;
		this.P2Label = P2Label;
	}




	@Override
	public void handle(ActionEvent event) {
		
		try {
			int minutes=Integer.parseInt(this.minutes.getText());
			int seconds=Integer.parseInt(this.seconds.getText());
			
			this.P1countDowntimer.changeMinutes(minutes);
			this.P1countDowntimer.changeSeconds(seconds);
			this.P2countDowntimer.changeMinutes(minutes);
			this.P2countDowntimer.changeSeconds(seconds);
			
			this.P1Label.setText(P1countDowntimer.toString());
			this.P2Label.setText(P2countDowntimer.toString());
			
			
			}
		catch(NumberFormatException nfe){
			this.minutes.setText("Try Again");
			this.seconds.setText("Try Again");
		}
	}

}
