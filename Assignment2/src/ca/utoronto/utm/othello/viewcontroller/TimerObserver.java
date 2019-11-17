package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;
import java.util.Arrays;

import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.animation.Animation;
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
	
		public TimerObserver() {
			this.P1Label.setId("0,8");
			this.P2Label.setId("0,10");
			this.P1timer.setCycleCount(Animation.INDEFINITE);
			this.P2timer.setCycleCount(Animation.INDEFINITE);
		}
	
		public CountDownTimer getCountDownTimerP1() {
			return this.P1countDowntimer;
		}
	
		public CountDownTimer getCountDownTimerP2() {
			return this.P2countDowntimer;
		}
	
		public ArrayList<Label> getTimerLabels() {
			ArrayList<Label> timerLabels = new ArrayList<Label>(Arrays.asList(this.P1Label, this.P2Label));
			return timerLabels;
		}
		
		public Label getp1Label() {
			return this.P1Label;
		}

		public Label getp2Label() {
			return this.P2Label;
		}
	
		public void update(Observable o) {
			MOthello mothello = (MOthello)o;
			
			if (!mothello.gameOver && mothello.getChange()) {
				if (mothello.getWhosTurn() == "P2") {
					this.P1timer.stop();
					this.P2timer.play();
				}
				else if (mothello.getWhosTurn() == "P1") {
					this.P2timer.stop();
					this.P1timer.play();
				}
			}
			else {
				this.P1timer.stop();
				this.P2timer.stop();
			}
				
		}
}
