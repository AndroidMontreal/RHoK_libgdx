package com.androidmontreal.rhok.pieces;

import java.util.Hashtable;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This piece represents the monster village where the water need to go.
 */
public class WaterExit implements Piece {

	private double quantity = 0 ;
	
	private Gate gateA;
	private Boolean ticked = false;
	private Point position;

	private Sprite sprite;

	public WaterExit() {
	} 
	
	@Override
	public Hashtable<Direction, Gate> getGates() {
		Hashtable<Direction, Gate> table = new Hashtable<Direction, Gate>();
		if (gateA != null) {
			table.put(gateA.getDirection(), gateA);
		}
		return table;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void tick(long timedelta) {
		Piece aPiece = gateA.getAttachedGate() != null ? gateA.getAttachedGate().getPiece() : null ;
		
		if( aPiece != null && aPiece.isTicked() ) {
			double pressure = gateA.getAttachedGate().getPressure();
			gateA.setPressure(pressure);
			
			double request = calculateRequest(pressure);
			if( pressure > 0 ) {
				quantity += aPiece.pullWater(request);
			} 
		}

		this.ticked = true;
	}

	double calculateRequest( double pressure ) {
		double absPressure = Math.abs(pressure);
		
		double waterRequest = absPressure; 
		return waterRequest ;
	}

	@Override
	public boolean isTicked() {
		return this.ticked;
	}

	@Override
	public void resetTick() {
		this.ticked = false;
	}

	@Override
	public Sprite getCurrentSprite() {
		return sprite;
	}

	@Override
	public double getWater() {
		return quantity;
	}

	@Override
	public void setWater(double volume) {
		this.quantity = volume ;
	}
	
	@Override
	public double pullWater(double volume) {
		return 0; // never pulls water from the monster village!
	}

}
