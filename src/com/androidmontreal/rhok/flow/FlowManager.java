package com.androidmontreal.rhok.flow;

import java.util.List;
import java.util.ArrayList;

import com.androidmontreal.rhok.board.Board;
import com.androidmontreal.rhok.pieces.Gate;
import com.androidmontreal.rhok.pieces.Piece;

public class FlowManager 
{
	private Board board;
	private List<Piece> piecesToProcess = new ArrayList<Piece>();
	
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
		this.piecesToProcess.add(currentPiece);
		
		currentPiece = this.piecesToProcess.iterator().next();
		while(currentPiece != null)
		{
			this.processPiece(currentPiece);
			currentPiece = this.piecesToProcess.iterator().next();
		}
	}
	
	private void processPiece(Piece piece)
	{
		//..  
		
		
		this.piecesToProcess
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
