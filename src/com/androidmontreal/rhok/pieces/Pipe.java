package com.androidmontreal.rhok.pieces;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This piece represents a pipe between two other pieces (pipes, water source,
 * pump, no piece)
 */

public class Pipe implements Piece {

	private List<Gate> gates = new ArrayList<Gate>();
	private Point position;
	private Boolean ticked;
	private Sprite sprite;
	private double water = 0.0d;
	
	

	public Pipe(Sprite sprite, Point position) {
		this.position = position;
		this.sprite = sprite;
	}

	public void setGates(List<Gate> gates) {
		this.gates = gates;
	}
	
	@Override
	public List<Gate> getGates() {
		return gates;
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


}
