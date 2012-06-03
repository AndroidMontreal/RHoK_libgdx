package com.androidmontreal.rhok;

import java.util.Hashtable;
import java.util.List;

import com.androidmontreal.rhok.board.Board;
import com.androidmontreal.rhok.controllers.BoardController;
import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pipe.PipeType;
import com.androidmontreal.rhok.pieces.Point;
import com.androidmontreal.rhok.pieces.factory.PipeFactory;
import com.androidmontreal.rhok.renderers.BoardRenderer;
import com.androidmontreal.rhok.renderers.PieceRenderer;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WaterSupplyGame implements ApplicationListener {

	private static final int TABLE_HEIGHT = 6;
	private static final int TABLE_WIDTH = 5;
	private Pipe[][] pipesTable;
	
	private SpriteBatch batch;
	private Sprite sprite;

	private double steps;

	private List<Piece> pieces;
	
	private Hashtable<PipeType, Sprite> pipeSprites;
	private Board board;
	private BoardRenderer boardRenderer;
	private BoardController boardController;

	
	@Override
	public void create() {
		
		ScreenDims screenDims = new ScreenDims();
		
		// pipesTable = new Pipe[TABLE_WIDTH][TABLE_HEIGHT];
		
		board = new Board(TABLE_WIDTH, TABLE_HEIGHT);
		boardRenderer = new BoardRenderer();
		boardController = new BoardController(board, boardRenderer,screenDims);
		
		// For each new piece.
		// new PieceRenderer(p);
		
		// TODO: Remove this I think...
		batch = new SpriteBatch();
	}
	
	private void initializeSomePieces() {
		
		for (int x = 0; x < TABLE_WIDTH; x++) {
			
			for (int y = 0; y < TABLE_HEIGHT; y++) {
				// TODO: Get rid when we have board working.
				pipesTable[x][y] = PipeFactory.getInstance().createPipe(PipeType.DOWN_LEFT, new Point(x, y));
				// [EC] I'm not bothering with this, I'll give the board a mock constructor or somethign instead. 
			} 		
		}
		
	}


	@Override
	public void resize(int width, int height) {
		System.out.println(String.format("%dx,%dy", width,height));

	}

	@Override
	public void render() {
		steps += 0.1;

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // This cryptic line clears
													// the screen.					
		
		/**
		 *  TOUCH EVENT
		 */
		if(Gdx.input.isTouched()){
			System.out.println("Screen is touch at "+Gdx.input.getX()+";"+Gdx.input.getY());
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			Piece touchedPiece = boardController.findPiece(x, y);
			Point position = touchedPiece.getPosition();
			position.setX(x);
			position.setY(y);
//			position.getY();
			boardController.addPiece(touchedPiece, Gdx.input.getX(), Gdx.input.getY());
		}
		
		
		
		batch.begin();
	
		boardRenderer.render() ;
		
//		int spacing = 22;
		
//		for (int x = 0; x < TABLE_WIDTH; x++) {			
//			for (int y = 0; y < TABLE_HEIGHT; y++) {
//				
//				Pipe p = pipesTable[x][y];
//			
//				int displayX = (x + 1) * spacing;
//				int displayY = (y + 1) * spacing;					
//							
//																
//			} 		
//		}
//		
		
		batch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	


}
