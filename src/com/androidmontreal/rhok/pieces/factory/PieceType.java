package com.androidmontreal.rhok.pieces.factory;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Gate;
import com.androidmontreal.rhok.pieces.Pipe;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PieceType 
{
	private Pipe.PipeType pipeType ;
	
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
