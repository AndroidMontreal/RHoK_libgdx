package com.androidmontreal.rhok.pieces;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.androidmontreal.rhok.pieces.Pipe.Type;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This piece represents a pipe between two other pieces (pipes, water source,
 * pump, no piece)
 */

public class Pipe implements Piece {
	enum Type { STRAIGHT, ELBOW } ;
	
	private static final double CAPACITY = 5 ;
	
	private Gate gateA ;
	private Gate gateB ;

	private Type type;
	
	private Point position;
	private Boolean ticked;
	private Sprite sprite;
	private double water = 0.0d;

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
		
		// TODO Auto-generated method stub
		
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
		return this.sprite;
	}
	

	@Override
	public double getWater()
	{
		return this.water;
	}

	@Override
	public void setWater(double volume)
	{
		this.water = volume;
	}

	@Override
	public double pullWater(double volume) {
		// TODO Auto-generated method stub
		return 0;
	}


}
