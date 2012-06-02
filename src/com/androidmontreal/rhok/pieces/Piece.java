package com.androidmontreal.rhok.pieces;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface Piece {

	List<Gate> getGates() ;
	
	Point getPosition();
	
	void tick( long timedelta );
	boolean isTicked();
	void resetTick();
	
	Sprite getCurrentSprite();
}
