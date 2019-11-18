package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;

public class RestartCommand implements Command {

	private Othello othello;
	
	public RestartCommand(Othello o) {
		this.othello = o;
	}
	
	@Override
	public void execute() {
		this.othello.restart();
	}

}
