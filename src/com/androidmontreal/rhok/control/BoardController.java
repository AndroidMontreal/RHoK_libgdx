package com.androidmontreal.rhok.control;

import com.androidmontreal.rhok.ScreenDims;
import com.androidmontreal.rhok.model.Board;
import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Point;
import com.androidmontreal.rhok.pieces.Pipe.PipeType;
import com.androidmontreal.rhok.renderers.BoardRenderer;
import com.androidmontreal.rhok.renderers.PipeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BoardController extends Actor {

	private final Board board;
	private final BoardRenderer renderer;
	public void render() {
		renderer.render();
	}

	private Pipe mockPipe;

	public BoardController(Board board, BoardRenderer renderer, ScreenDims dims ) {
		this.board = board;
		this.renderer = renderer;
		
		// TODO: Remove mock stuff.
//		mockPipe = new Pipe(PipeType.DOWN_LEFT, new Point(dims.getWidth()/2, dims.getHeight()/2));
//		PipeRenderer pipeRenderer = new PipeRenderer(mockPipe);
//		this.renderer.addPieceRenderer(pipeRenderer);
		
	}
	
	public void addPiece(Piece piece, int x, int y){
		//TODO implements
	}
	
	public Piece findPiece( int x, int y ) {
		return mockPipe ;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor hit(float x, float y) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
