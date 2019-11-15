package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;

public class HumanBehaviour implements moveStrategy {
	
	private String id;
	
	public HumanBehaviour() {
		this.id = "HumanBehaviour";
	}
	
	public Move moveCommand() {
		return null;
	}

	public String getId() {
		return this.id;
	}

}
