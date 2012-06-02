package com.androidmontreal.rhok.pieces;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This piece represents the monster village where the water need to go.
 */
public class MonsterVillage implements Piece {

	private Gate sourceEntry;
	private Boolean ticked = false;
	private Point position;
	
	@Override
	public List<Gate> getGates() {
		ArrayList<Gate> gates = new ArrayList<Gate>();
		if (sourceEntry != null) {
			gates.add(sourceEntry);
		}
		return gates;
	}

	@Override
	public Point getPosition() {
		return position;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWater() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWater(double volume) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public double pullWater(double volume) {
		return 0; // never pulls water from the monster village!
	}

}
