package com.androidmontreal.rhok.board;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Direction;
import com.androidmontreal.rhok.pieces.DirectionUtil;
import com.androidmontreal.rhok.pieces.Piece;

public class Board {
	
	private static void attachPieces(Piece p1, Piece p2, Direction direction)
	{
		p1.getGates().get(direction).setAttachedGate(p2.getGates().get(DirectionUtil.getOpposite(direction)));
	}

	// Logical board sizes, in tiles.
	int width ;

	int height ;

	/// Display graph, empty cells are null.
	Piece[][] boardPieces ;

	/// Display graph, empty cells are null.
	List<Piece> pieces = new ArrayList<Piece>();
	Piece rootPiece = null;
	
	public Board( int width, int height ) {
		boardPieces = new Piece[width][height];
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
	
	public Piece findPiece( int x, int y ) {
		// TODO: Implement
		return null ;
	}
	
	public Piece[][] getBoardPieces() {
		return boardPieces;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	public Piece getRootPiece()
	{
		return this.rootPiece;
	}
	
	public void setBoardPieces(Piece[][] boardPieces) {
		this.boardPieces = boardPieces;
	}
	
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
	
	public void setRootPiece(Piece piece)
	{
		this.rootPiece = piece;
	}
	
}
