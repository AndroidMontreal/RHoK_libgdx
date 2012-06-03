package com.androidmontreal.rhok.pieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PieceImage extends Image{
	
	Piece piece;
	
	public PieceImage(Texture texture, Piece piece){
		super(texture);
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}
