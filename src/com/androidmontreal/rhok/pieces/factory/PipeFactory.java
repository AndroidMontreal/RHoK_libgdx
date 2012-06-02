package com.androidmontreal.rhok.pieces.factory;

import java.util.ArrayList;
import java.util.List;

import com.androidmontreal.rhok.pieces.Direction;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Point;
import com.androidmontreal.rhok.pieces.Pipe.Type;

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
		// FIXME: Boris!
		Pipe pipe = new Pipe(null,getRandomPipeType(), getRandomDirection());
		
		return pipe;
	}
	
	private Pipe.Type getRandomPipeType()
	{
		int index = (int) ( Math.random() * (Pipe.Type.values().length + 1));
		return Pipe.Type.values()[index];
	}
	
	private Direction getRandomDirection() {
		int index = (int) ( Math.random() * (Direction.values().length + 1));
		return Direction.values()[index];
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
