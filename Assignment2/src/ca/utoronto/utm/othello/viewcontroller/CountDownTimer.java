package ca.utoronto.utm.othello.viewcontroller;


import javafx.scene.control.Label;

public class CountDownTimer{
	int minutes;
	int seconds;
	Label label;
	private String player;
	
	public CountDownTimer(Label l, String player) {
		this.minutes = 5;
		this.seconds = 0;
		this.label = l;
		this.player = player;
	}
	
	public void changeMinutes(int min) {
		this.minutes = min;
	}
	
	public void changeSeconds(int sec) {
		this.seconds = sec;
		
	}
	
	public void countDown() {
		if (seconds == 0 && minutes > 0) {
			seconds = 59;
			minutes -= 1;
		}
		else if (seconds > 0) {
			seconds -= 1;
		}
	}
	
	public void resetTimer() {
		this.minutes = 5;
		this.seconds = 0;
	}
	
	
	public String toString() {
		String stringMin = "";
		String stringSec = "";
		
		if (this.minutes < 10) {
			stringMin = stringMin + "0" + minutes;
		}
		else if (this.minutes >= 10) {
			stringMin = stringMin + minutes;
		}
		if (this.seconds < 10) {
			stringSec = stringSec + "0" + seconds;
		}
		else if (this.seconds >= 10) {
			stringSec = stringSec + seconds;
		}
		
		return player + " " + "Time Remaining: " + stringMin + ":" + stringSec;
	}

	public void run() {
		this.countDown();
		this.label.setText(this.toString());
	}

}

	


