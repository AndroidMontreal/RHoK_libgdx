package com.androidmontreal.rhok.board;

import com.androidmontreal.rhok.pieces.Piece;

public class Board {
	
	// Logical board sizes, in tiles.
	int width ;
	int height ;
	
	/// Display graph, empty cells are null.
	Piece[][] boardPieces ;
	
	public Board( int width, int height ) {
		boardPieces = new Piece[width][height];
	}
	
}
