package com.androidmontreal.rhok.pieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PieceImage extends Image{
	
	Piece piece;
	
	public PieceImage(Texture texture, Piece piece){
		super(texture);
		this.piece = piece;
	}
	
	@Override
	public boolean touchDown(float x, float y, int pointer) {
		System.out.println(String.format("pieceimage touchdown detect %f,%f", x, y));
		return true;
	}
	
	@Override
	public void touchUp(float x, float y, int pointer) {
		System.out.println(String.format("pieceimage touchUp detect %f,%f", x, y));
		
	}
	
	@Override
	public void touchDragged(float x, float y, int pointer) {
		System.out.println(String.format("pieceimage dragged detect %f,%f", x, y));
		this.x = x;
		this.y = y;
	}

}
