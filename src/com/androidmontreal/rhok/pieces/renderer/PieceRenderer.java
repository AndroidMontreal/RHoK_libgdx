package com.androidmontreal.rhok.pieces.renderer;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pump;

public class PieceRenderer {
	
	public PieceRenderer(Piece p) {
		
		if(p instanceof Pipe){
			new PipeRenderer((Pipe)p).render();
		}elseif(p instanceof Pump){
						
		}
		
	}

}
