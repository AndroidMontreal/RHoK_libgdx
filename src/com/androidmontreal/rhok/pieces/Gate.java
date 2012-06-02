package com.androidmontreal.rhok.pieces;

public interface Gate {

	void setAttachedGate(Gate gate);
	Gate getAttachedGate();

	void setDirection(Direction direction);
	Direction getDirection();

	void setPressure(double pressure) ;
	double getPressure() ;
	
	Piece getPiece();
	
}
