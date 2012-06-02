package com.androidmontreal.rhok.pieces.factory;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Point;

public class PipeFactory 
{

	private static PipeFactory instance;
	
	private List<PieceType> pieceType = new ArrayList<PieceType>();
	
	public void addPieceType(PieceType type)
	{
		this.pieceType.add(type);
	}
	
	public Pipe create(Point point)
	{
		PieceType type = this.getRandomPipeType();
		
		Pipe pipe = new Pipe(type.getSprite(), point);
		pipe.setGates(type.getGates());
		
		return pipe;
	}
	
	private PieceType getRandomPipeType()
	{
		int index = (int) ( Math.random() * (this.pieceType.size() + 1));
		return this.pieceType.get(index);
	}
	
	public static PipeFactory getInstance()
	{
		if(instance == null)
		{
			instance = new PipeFactory();
		}
		return instance;
	}
	
}
