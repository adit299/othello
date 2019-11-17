package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TimerObserver implements Observer {
	
	
	private Label P1Label = new Label("P1 Time Remaining: 5:00");
	private CountDownTimer P1countDowntimer = new CountDownTimer(P1Label, "P1");
	private Label P2Label = new Label("P2 Time Remaining: 5:00");
	private CountDownTimer P2countDowntimer = new CountDownTimer(P2Label, "P2");
	private Timeline P1timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        P1countDowntimer.run();
    }));
	private Timeline P2timer = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        P2countDowntimer.run();
    }));

	
	@Override
	public void update(Observable o) {
		// TODO Auto-generated method stub
		
	}

}
