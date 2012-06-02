package com.androidmontreal.rhok.flow;

import com.androidmontreal.rhok.board.Board;
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
		
		while(currentPiece != null)
		{
			this.processPiece(currentPiece);
			currentPiece = this.getAdjacentPiece(currentPiece);
		}
	}
	
	private void processPiece(Piece piece)
	{
		
	}
	
	private Piece getAdjacentPiece(Piece piece)
	{
		for (Gate gate : piece.getGates()) {
			if(gate.getAttachedGate() != null)
			{
				return gate.getAttachedGate().getPiece();
			}
		}
		return null;
	}
	
}
