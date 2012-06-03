package com.androidmontreal.rhok.model;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Piece;

/**
 * <p>Sideboard holds the Pieces the player can pick from to add to the board. 
 *
 */
public class Sideboard {

	private final List<Piece> pieces = new ArrayList<Piece>();
	
	public Sideboard() {
		
	}
	
	public Sideboard( List<Piece> startingPieces ) {
		pieces.addAll(startingPieces);
	}

	public boolean add(Piece e) {
		return pieces.add(e);
	}

	public void clear() {
		pieces.clear();
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public boolean remove(Object o) {
		return pieces.remove(o);
	}

}
