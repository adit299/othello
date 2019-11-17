package ca.utoronto.utm.othello.model;

import java.util.ArrayList;

/**
 * PlayerStrategic makes a move by considering possible moves
 * it will prioritize moves in the order
 * corner moves
 * side moves
 * 4x4 middle presence moves
 * greedy moves
 */
public class PlayerStrategic extends Player {
	public PlayerStrategic(Othello othello, char player) {
		super(othello, player);
	}
	
	@Override
	public Move getMove() {
		Othello othelloCopy = othello.copy();
		ArrayList<Move> cornerMoves = new ArrayList<Move>();
		ArrayList<Move> sideMoves = new ArrayList<Move>();
		
		Move bestGreedyMove=new Move(0,0);
		Move bestMidMove=new Move(-1,0);
		int bestGreedyMoveCount = othelloCopy.getCount(this.player);
		int bestMidCount = othelloCopy.getMidCount(this.player);
		for(int row=0;row<Othello.DIMENSION;row++) {
			for(int col=0;col<Othello.DIMENSION;col++) {
				othelloCopy = othello.copy();
				
				if(othelloCopy.move(row, col)){
					if (checkCorner(row,col)) {
						cornerMoves.add(new Move(row,col));
					}
					if (checkSide(row,col)) {
						sideMoves.add(new Move(row,col));
					}
					if (othelloCopy.getCount(this.player)>bestGreedyMoveCount) {
					bestGreedyMoveCount = othelloCopy.getCount(this.player);
					bestGreedyMove = new Move(row,col);
					}
					if (othelloCopy.getCount(this.player)>bestMidCount) {
						bestMidCount = othelloCopy.getCount(this.player);
						bestMidMove = new Move(row,col);
					}
				}
			}
		}
		if (!cornerMoves.isEmpty()) {
			return cornerMoves.get(0);
		}
		if (!sideMoves.isEmpty()) {
			return sideMoves.get(0);
		}
		if (bestMidMove.getRow() == -1) {
			return bestGreedyMove;
		}
		return bestMidMove;
	}
	
	
	private boolean checkCorner(int row, int col) {
		if (row == 0 && col == 0) {
			return true;
		}
		if (row == Othello.DIMENSION-1 && col == 0) {
			return true;
		}
		if (row == 0 && col == Othello.DIMENSION-1) {
			return true;
		}
		if (row == Othello.DIMENSION-1 && col == Othello.DIMENSION-1) {
			return true;
		}
		return false;
	}
	
	private boolean checkSide(int row, int col) {
		if (row == 0 || col == 0) {
			return true;
		}
		if (row == Othello.DIMENSION-1 || col == Othello.DIMENSION-1) {
			return true;
		}
		return false;
	}

}

