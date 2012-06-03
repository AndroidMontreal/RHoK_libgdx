package com.androidmontreal.rhok.renderers;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.WaterExit;
import com.androidmontreal.rhok.pieces.WaterSource;

public class PieceRenderer {
	
	private IRenderer r;

	public PieceRenderer(Piece p) {
		
		if(p instanceof Pipe){
			r = new PipeRenderer((Pipe)p);
		}else if(p instanceof Pump){
			r = new PumpRenderer((Pump)p);
		}else if(p instanceof WaterSource){
			r = new WaterSourceRenderer((WaterSource)p);
		}else if(p instanceof WaterExit){
			r = new WaterExitRenderer((WaterExit)p);
		}else{
			throw new RuntimeException("Unknow renderer for type : " + p);
		}
		
		//TODO: Add more type renderer
		
	}
		
	public void render() {
		r.render();
	}

}
