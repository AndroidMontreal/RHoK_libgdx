package com.androidmontreal.rhok.pieces;

import java.util.Hashtable;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This piece represents a pipe between two other pieces (pipes, water source,
 * pump, no piece)
 */

public class Pipe implements Piece {
	public enum Type { STRAIGHT, ELBOW } ;
	
	private static final double CAPACITY = 5 ;
	
	private Gate gateA ;
	private Gate gateB ;

	private Type type;
	
	private Point position;
	private Boolean ticked;
	private Sprite sprite;
	private double waterContent = 0.0d;


	public Pipe(Sprite sprite, Type type, Direction direction ) {
		this.sprite = sprite;
		this.type = type ;
		
		if( this.type == Type.STRAIGHT ) {
			switch( direction ) {
				case UP :
					gateA = new WaterGate(this, Direction.UP);
					gateB = new WaterGate(this, Direction.DOWN);
					break ;
				case RIGHT :
					gateA = new WaterGate(this, Direction.RIGHT);
					gateB = new WaterGate(this, Direction.LEFT);
					break ;
				case DOWN :
					gateA = new WaterGate(this, Direction.DOWN);
					gateB = new WaterGate(this, Direction.UP);
					break ;
				case LEFT :
					gateA = new WaterGate(this, Direction.LEFT);
					gateB = new WaterGate(this, Direction.RIGHT);
					break ;
			}
		} else if (this.type == Type.ELBOW) {
			switch (direction) {
			case UP:
				gateA = new WaterGate(this, Direction.UP);
				gateB = new WaterGate(this, Direction.RIGHT);
				break;
			case RIGHT:
				gateA = new WaterGate(this, Direction.RIGHT);
				gateB = new WaterGate(this, Direction.DOWN);
				break;
			case DOWN:
				gateA = new WaterGate(this, Direction.DOWN);
				gateB = new WaterGate(this, Direction.LEFT);
				break;
			case LEFT:
				gateA = new WaterGate(this, Direction.LEFT);
				gateB = new WaterGate(this, Direction.UP);
				break;
			}
		}

	}


	@Override
	public Hashtable<Direction, Gate> getGates() {
		Hashtable<Direction, Gate> table = new Hashtable<Direction, Gate>();
		table.put(gateA.getDirection(), gateA);
		table.put(gateB.getDirection(), gateB);
		return table;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public void tick(long timedelta) {
		Piece aPiece = gateA.getAttachedGate() != null ? gateA.getAttachedGate().getPiece() : null ;
		Piece bPiece = gateB.getAttachedGate() != null ? gateB.getAttachedGate().getPiece() : null ;
		
		// Equalize pressure
		if( aPiece != null && aPiece.isTicked() ) {
			double pressure = gateA.getAttachedGate().getPressure();
			gateB.setPressure( pressure );
			double request = calculateRequest(pressure);
			if( pressure > 0 ) {
				waterContent += aPiece.pullWater(pressure);
			} else {
				
			}
		}
		
		if( bPiece != null && bPiece.isTicked() ) {
			double pressure = gateB.getAttachedGate().getPressure();
			gateA.setPressure( gateB.getAttachedGate().getPressure() );

		}
		
		this.ticked = true;
	}

	double calculateRequest( double pressure ) {
		double abs = Math.abs(pressure);
		
		double waterRequest = 0 ;
		if( pressure > ( CAPACITY - waterContent ) ) {
			waterRequest = CAPACITY - waterContent ;
		} else {
			waterRequest = pressure; 
		}
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
		return this.sprite;
	}
	

	@Override
	public double getWater()
	{
		return this.waterContent;
	}

	@Override
	public void setWater(double volume)
	{
		this.waterContent = volume;
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
