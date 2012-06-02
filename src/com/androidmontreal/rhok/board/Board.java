package com.androidmontreal.rhok.board;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Direction;
import com.androidmontreal.rhok.pieces.Gate;

public class Board {
	
	
	/// Display graph, empty cells are null.
	List<Piece> pieces = new ArrayList<Piece>();
	Piece rootPiece = null;
	
	public Board( ) 
	{
		
	}
	
	public void addPiece(Piece piece)
	{
		this.pieces.add(piece);
		this.checkPieceAttachements(piece);
	}
	
	private void checkPieceAttachements(Piece currentPiece)
	{
		for (Piece piece : this.pieces) {
			if(piece != currentPiece)
			{
				Direction relation = currentPiece.getPosition().nextTo(piece.getPosition());
				if(relation != null)
				{
					attachPieces(piece, currentPiece, relation);
				}
			}
		}
	}
	
	private static void attachPieces(Piece p1, Piece p2, Direction direction)
	{
//		for (Gate gate : p1.getGates()) {
//			if(gate.getDirection() == direction)
//			{
//				gate.setAttachedGate(gate)
//			}
//		}
	}
	
	public void setRootPiece(Piece piece)
	{
		this.rootPiece = piece;
	}
	
	public Piece getRootPiece()
	{
		return this.rootPiece;
	}
	
}
