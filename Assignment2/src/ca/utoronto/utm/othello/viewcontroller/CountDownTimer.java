package ca.utoronto.utm.othello.viewcontroller;


import javafx.scene.control.Label;

/**
 * The Class CountDownTimer.
 */
public class CountDownTimer{
	
	/** The minutes. */
	int minutes;
	
	/** The seconds. */
	int seconds;
	
	/** The label. */
	Label label;
	
	/** The player. */
	private String player;
	
	/**
	 * Instantiates a new count down timer.
	 *
	 * @param l the label
	 * @param player the player
	 */
	public CountDownTimer(Label l, String player) {
		this.minutes = 5;
		this.seconds = 0;
		this.label = l;
		this.player = player;
	}
	
	/**
	 * Change minutes.
	 *
	 * @param min the minute
	 */
	public void changeMinutes(int min) {
		this.minutes = min;
	}
	
	/**
	 * Change seconds.
	 *
	 * @param sec the second
	 */
	public void changeSeconds(int sec) {
		this.seconds = sec;
		
	}
	
	/**
	 * Count down.
	 */
	public void countDown() {
		if (seconds == 0 && minutes > 0) {
			seconds = 59;
			minutes -= 1;
		}
		else if (seconds > 0) {
			seconds -= 1;
		}
	}
	
	/**
	 * Reset timer.
	 */
	public void resetTimer() {
		this.minutes = 5;
		this.seconds = 0;
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
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

	/**
	 * Run.
	 */
	public void run() {
		this.countDown();
		this.label.setText(this.toString());
	}

}

	


