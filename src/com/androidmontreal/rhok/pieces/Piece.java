package com.androidmontreal.rhok.pieces;

import java.util.Hashtable;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface Piece {

	Hashtable<Direction, Gate> getGates() ;
	
	Point getPosition();
	
	// 
	void tick( long timedelta );
	boolean isTicked();
	void resetTick();
	
	Sprite getCurrentSprite();
	
	double getWater();
	void setWater(double volume);
	
	/** Request a volume, you get what's available... */
	double pullWater( double volume ); 
}
