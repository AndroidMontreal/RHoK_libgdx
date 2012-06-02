package com.androidmontreal.rhok.pieces;

import java.util.Hashtable;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This piece represents a water source where the water needed by the monster village is available.
 */
public class WaterSource implements Piece {

	private final Sprite sprite;

	private double waterContent;
	
	private Gate sourceExit;
	private Boolean ticked;
	
	private Point position = null ;  // DEFAULT

	
	public WaterSource(Sprite sprite ) {
		this.sprite = sprite;
		this.waterContent = Double.MAX_VALUE ; 
	}
	
	@Override
	public Hashtable<Direction, Gate> getGates() {
		if (sourceExit == null) {
			return null;
		}
		Hashtable<Direction, Gate> gates = new Hashtable<Direction, Gate>();
		gates.put(sourceExit.getDirection(), sourceExit);
		return gates;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void tick(long timedelta) {
		// Nothing to do..
		this.ticked = true;  
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
		return Double.MAX_VALUE ;
	}

	@Override
	public void setWater(double volume) {
		this.waterContent = volume ;
	}
	
	@Override
	public double pullWater(double volume) {
		double retVal = 0 ;
		if( volume > waterContent ) {
			retVal = waterContent ;
			waterContent = 0 ;
		} else {
			retVal = volume ;
			waterContent -= volume ;
		}
		
		return retVal ;
	}

}
