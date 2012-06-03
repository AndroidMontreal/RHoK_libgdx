package com.androidmontreal.rhok.board;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.ScreenDims;
import com.androidmontreal.rhok.pieces.Direction;
import com.androidmontreal.rhok.pieces.DirectionUtil;
import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pipe.PipeType;
import com.androidmontreal.rhok.pieces.Point;

public class Board {
	
	private static void attachPieces(Piece p1, Piece p2, Direction direction)
	{
		p1.getGates().get(direction).setAttachedGate(p2.getGates().get(DirectionUtil.getOpposite(direction)));
	}

	// Physical dims of screen, needed to provide touch services...
	private final ScreenDims dims;
	
	// Logical board sizes, in tiles.
	int width ;
	int height ;

	/// Display graph, empty cells are null.
	Piece[][] boardPieces ;

	/// Display graph, empty cells are null.
	List<Piece> pieces = new ArrayList<Piece>();
	Piece rootPiece = null;

	private Pipe mockPipe;
	
	public Board( int width, int height, ScreenDims dims ) {
		this.dims = dims;
		boardPieces = new Piece[width][height];
		
		// TODO: Remove mock stuff.
		mockPipe = new Pipe(PipeType.DOWN_LEFT, new Point(dims.getWidth()/2, dims.getHeight()/2));
		pieces.add(mockPipe); 
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
		return mockPipe ;
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
