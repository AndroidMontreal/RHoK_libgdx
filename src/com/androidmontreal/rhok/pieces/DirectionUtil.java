package com.androidmontreal.rhok.pieces;

public class DirectionUtil {
	
	public static Direction getOpposite(Direction direction)
	{
		switch(direction)
		{
			case UP: 		return Direction.DOWN; 
			case DOWN: 		return Direction.UP;
			case RIGHT: 	return Direction.LEFT; 
			case LEFT: 		return Direction.RIGHT; 
		}
		return null;
	}

}
