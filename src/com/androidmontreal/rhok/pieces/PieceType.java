package com.androidmontreal.rhok.pieces;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Gate;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PieceType 
{
	private Sprite sprite;
	private List<Gate> gates = new ArrayList<Gate>();
	
	public PieceType(Sprite sprite)
	{
		this.sprite = sprite;
	}
	
	public Sprite getSprite()
	{
		return this.sprite;
	}
	
	public void addGate(Gate gate)
	{
		this.gates.add(gate);
	}
	
	public List<Gate> getGates()
	{
		return this.gates;
	}
}
