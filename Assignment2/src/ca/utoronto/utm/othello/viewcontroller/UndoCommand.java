package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;

public class UndoCommand implements Command {

	private Othello othello;
	private boolean AIC;
	
	public UndoCommand(Othello o, boolean AIC) {
		this.othello = o;
		this.AIC = AIC;
	}
	
	@Override
	public void execute() {
		this.othello.undo(this.AIC);
	}

}
