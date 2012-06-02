package com.androidmontreal.rhok.pieces;

public class WaterGate implements Gate {

	Piece parentPiece;
	Gate attachedGate;
	Direction direction;
	Double pressure;

	public WaterGate( Piece parentPiece, Direction direction ) {
		this.parentPiece = parentPiece;
	}

	@Override
	public void setAttachedGate(Gate gate) {
		attachedGate = gate;
	}

	@Override
	public Gate getAttachedGate() {
		return attachedGate;
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@Override
	public double getPressure() {
		return pressure;
	}

	@Override
	public Piece getPiece() {
		return parentPiece;
	}

}
