package com.androidmontreal.rhok.pieces.renderer;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;

public class PieceRenderer {
	
	private PipeRenderer renderer;

	public PieceRenderer(Piece p) {
		
		if(p instanceof Pipe){
			renderer = new PipeRenderer((Pipe)p);
		}
		
		//TODO: Add more type render
		
	}
		
	public void render() {
		renderer.render();
	}

}
