package com.androidmontreal.rhok.renderers;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pump;

public class PieceRenderer {
	
	private IRenderer r;

	public PieceRenderer(Piece p) {
		
		if(p instanceof Pipe){
			r = new PipeRenderer((Pipe)p);
		}else if(p instanceof Pump){
			r = new PumpRenderer((Pump)p);
		}
		
		//TODO: Add more type render
		
	}
		
	public void render() {
		r.render();
	}

}
