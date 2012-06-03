package com.androidmontreal.rhok.pieces;

public class Point {
	int x ;
	int y ;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Point getDelta(Point point)
	{
		int dx = point.x - x;
		int dy = point.y - y;
		
		return new Point(dx, dy);
	}
	
	public Direction nextTo(Point point)
	{
		if(point.x == x && point.y == y - 1)
		{
			return Direction.UP;
		}
	
		if(point.x == x && point.y == y + 1)
		{
			return Direction.DOWN;
		}
	
		if(point.x == x + 1 && point.y == y)
		{
			return Direction.RIGHT;
		}
	
		if(point.x == x - 1 && point.y == y)
		{
			return Direction.LEFT;
		}
		
		return null;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
