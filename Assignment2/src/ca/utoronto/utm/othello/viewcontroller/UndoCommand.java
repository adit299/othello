package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;


/**
 * The Class UndoCommand.
 */
public class UndoCommand implements Command {

	/** The othello. */
	private Othello othello;
	
	/** The aic. */
	private boolean AIC;
	
	/**
	 * Instantiates a new undo command.
	 *
	 * @param o the o
	 * @param AIC the aic
	 */
	public UndoCommand(Othello o, boolean AIC) {
		this.othello = o;
		this.AIC = AIC;
	}
	
	/**
	 * Execute.
	 */
	@Override
	public void execute() {
		this.othello.undo(this.AIC);
	}

}
