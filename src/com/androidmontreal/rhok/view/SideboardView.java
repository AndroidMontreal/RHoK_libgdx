package com.androidmontreal.rhok.view;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Point;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SideboardView {
	// Will act as a holder for our x, y + widht, height.
	// Will likely only want a very light tint color png to highlight the zone.
	Sprite backdrop ;

	PieceView[] slots ;
	
	public SideboardView(float x, float y, float width, float height, int slots ) {
		this.backdrop.setSize(width, height);
		this.backdrop.setPosition(x, y);
		this.slots = new PieceView[slots] ;
	}
	
	
	public void assignPiece( Piece piece, int slot ) {
		
	}
	
	/** 
	 *  <p>Call this to grab a piece from the sideboard, returns null if nothing under user's finger.
	 */
	public PieceView grabPiece( int x, int y ) {
		for( PieceView current : slots ) {
			if( current != null ) {
//				Point position = current.getPosition() ;
				
			}
		}
		return null;
	}
}
