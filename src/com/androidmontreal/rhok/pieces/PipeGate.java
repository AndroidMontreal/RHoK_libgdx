package com.androidmontreal.rhok.pieces;

public class PipeGate implements Gate {

	Gate attachedGate;
	Direction direction;
	Piece parentPiece;
	Double pressure;
	
	public PipeGate(Direction direction) {
		this.direction = direction;
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
