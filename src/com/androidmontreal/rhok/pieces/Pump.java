package com.androidmontreal.rhok.pieces;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Pump implements Piece {

	private final static double CAPACITY = 25 ;
	private final Sprite sprite;
	
	Point point = null ;
	
	boolean ticked ;
	
	Gate outputGate ;
	Gate inputGate ;
	
	double outputPressure ;

	private double waterContent;

	
	public Pump( Direction outputDirection, double pressure, Sprite sprite ) {
		
		this.sprite = sprite;
		
		switch( outputDirection ) {
			case UP :
				outputGate = new WaterGate(this, Direction.UP);
				inputGate = new WaterGate(this, Direction.DOWN);
				break ;
			case RIGHT :
				outputGate = new WaterGate(this, Direction.RIGHT);
				inputGate = new WaterGate(this, Direction.LEFT);
				break ;
			case DOWN :
				outputGate = new WaterGate(this, Direction.DOWN);
				inputGate = new WaterGate(this, Direction.UP);
				break ;
			case LEFT :
				outputGate = new WaterGate(this, Direction.LEFT);
				inputGate = new WaterGate(this, Direction.RIGHT);
				break ;
		}
	
		this.outputPressure = pressure ;
	}
	
	@Override
	public List<Gate> getGates() {
		ArrayList<Gate> arrayList = new ArrayList<Gate>();
		arrayList.add(outputGate);
		arrayList.add(inputGate);
		return arrayList;
	}

	@Override
	public Point getPosition() {
		return point;
	}

	@Override
	public void tick(long timedelta) {
		inputGate.setPressure(-outputPressure);
		outputGate.setPressure(outputPressure);

		double waterRequest = 0 ;
		if( outputPressure > ( CAPACITY - waterContent ) ) {
			waterRequest = CAPACITY - waterContent ;
		} else {
			waterRequest = outputPressure; 
		}
		
		waterContent += inputGate.getAttachedGate().getPiece().pullWater(waterRequest);
		
	}

	@Override
	public boolean isTicked() {
		return ticked;
	}

	@Override
	public void resetTick() {
		ticked = false ;
	}

	@Override
	public Sprite getCurrentSprite() {
		return sprite ;
	}

	@Override
	public double getWater() {
		return waterContent;
	}

	@Override
	public void setWater(double volume) {
		waterContent = volume ;
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
