package ca.utoronto.utm.othello.viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The Class TimerButtonEventHandler.
 */
public class TimerButtonEventHandler implements EventHandler<ActionEvent> {
	
	/** The minutes. */
	private TextField minutes;
	
	/** The seconds. */
	private TextField seconds;
	
	/** The P 1 label. */
	private Label P1Label = new Label("P1 Time Remaining: ");
	
	/** The P 2 label. */
	private Label P2Label = new Label("P2 Time Remaining: ");
	
	/** The P 1 count downtimer. */
	private CountDownTimer P1countDowntimer;
	
	/** The P 2 count downtimer. */
	private CountDownTimer P2countDowntimer;

	/**
	 * Instantiates a new timer button event handler.
	 *
	 * @param countDownTimerP1 the count down timer P 1
	 * @param countDownTimerP2 the count down timer P 2
	 * @param minutes the minutes
	 * @param seconds the seconds
	 * @param P1Label the p 1 label
	 * @param P2Label the p 2 label
	 */
	public TimerButtonEventHandler(CountDownTimer countDownTimerP1, CountDownTimer countDownTimerP2, 
			TextField minutes, TextField seconds, Label P1Label, Label P2Label) {
		this.P1countDowntimer = countDownTimerP1;
		this.P2countDowntimer = countDownTimerP2;
		this.minutes = minutes;
		this.seconds = seconds;
		this.P1Label = P1Label;
		this.P2Label = P2Label;
	}

	/**
	 * Handle.
	 *
	 * @param event the event
	 */
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
