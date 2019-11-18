package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;


/**
 * The Class RestartCommand.
 */
public class RestartCommand implements Command {

	/** The othello. */
	private Othello othello;
	
	/**
	 * Instantiates a new restart command.
	 *
	 * @param o the o
	 */
	public RestartCommand(Othello o) {
		this.othello = o;
	}
	
	/**
	 * Execute.
	 */
	@Override
	public void execute() {
		this.othello.restart();
	}

}
