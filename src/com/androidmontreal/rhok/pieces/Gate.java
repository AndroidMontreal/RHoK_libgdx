package com.androidmontreal.rhok.pieces;

public interface Gate {

	void setAttachedPiece(Gate gate);
	Gate getAttachedPiece();

	void setDirection(Direction direction);
	Direction getDirection();

	void setPressure(double pressure) ;
	double getPressure() ;
	
}
