package ca.utoronto.utm.othello.viewcontroller;

import java.util.ArrayList;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;

public class OthelloObservable extends Observable {
	private ArrayList<OthelloObserver> OthelloObservers = new ArrayList<OthelloObserver>();
	public static Othello othello;
	
	public void attach(OthelloObserver o) {
		OthelloObservers.add(o);
		
	}
	public void detach(OthelloObserver o) {
		OthelloObservers.remove(o);
	}
	
//	public void notifyObservers() {
//		for(OthelloObserver o:OthelloObservers) {
//			o.update(this);
//		}
//	}
	
}
	


