package com.androidmontreal.rhok.flow;

import com.androidmontreal.rhok.model.Board;
import com.androidmontreal.rhok.pieces.Gate;
import com.androidmontreal.rhok.pieces.Piece;

public class FlowManager 
{
	private Board board;
	
	public FlowManager(Board board)
	{
		this.board = board;
	}
	
	public void tick(long timeDelta)
	{
		Piece firstPiece = this.board.getRootPiece();
		if(firstPiece == null)
		{
			return;
		}
		
		Piece currentPiece = firstPiece;
		
		if(currentPiece != null)
		{
			this.tickPiece(currentPiece, timeDelta);
		}
	}
	
	// Allows us to propagate data....?
	private void tickPiece(Piece currentPiece, long timeDelta)
	{
		// Piece will have logic to get info and water from neighbors.
		currentPiece.tick(timeDelta); // TODO: Split tick in pressure tick then water tick?
			
		Piece untickedChildPiece = findNextUnticked( currentPiece ); 
		while( untickedChildPiece != null ) {
			tickPiece(untickedChildPiece, timeDelta);
			untickedChildPiece = findNextUnticked( currentPiece );
		}
	}
	
	// Unticked are due to be worked on...
	private Piece findNextUnticked(Piece currentPiece) {
		
		for (Gate gate : currentPiece.getGates().values()) {
			Gate attachedGate = gate.getAttachedGate();
			if( attachedGate !=null ) {
				Piece piece = attachedGate.getPiece();
				if( ! piece.isTicked() ) {
					return piece ;
				}
			}
		}
		
		return null;
	}

}
