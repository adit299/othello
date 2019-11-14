package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Move;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.util.Observable;

public class GreedyBehaviour implements moveStrategy {
	private MOthello mothello;
	private Othello othello;
	private PlayerGreedy playerGreedy = new PlayerGreedy(othello, OthelloBoard.P2);

	public GreedyBehaviour(MOthello mothello, Othello othello) {
		this.mothello = mothello;
		this.othello = othello;
	}

	@Override
	public Move moveCommand() {
//		Othello othelloCopy = this.othello.copy();
//		Move bestMove=new Move(0,0);
//		int bestMoveCount=othelloCopy.getCount(OthelloBoard.P2);;
//		for(int row=0;row<Othello.DIMENSION;row++) {
//			for(int col=0;col<Othello.DIMENSION;col++) {
//				othelloCopy = othello.copy();
//				if(othelloCopy.move(row, col) && othelloCopy.getCount(OthelloBoard.P2)>bestMoveCount) {
//					bestMoveCount = othelloCopy.getCount(OthelloBoard.P2);
//					bestMove = new Move(row,col);
//					System.out.println(bestMove.toString());
					Move bestMove = new Move(2, 3);
		
//				}
//			}
//		}
		return bestMove;
		
	}
	

}
