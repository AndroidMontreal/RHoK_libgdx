package com.androidmontreal.rhok;

import java.util.Hashtable;
import java.util.List;

import com.androidmontreal.rhok.control.BoardController;
import com.androidmontreal.rhok.control.PieceController;
import com.androidmontreal.rhok.control.SideboardController;
import com.androidmontreal.rhok.model.Board;
import com.androidmontreal.rhok.model.Sideboard;
import com.androidmontreal.rhok.pieces.Direction;
import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pipe.PipeType;
import com.androidmontreal.rhok.pieces.Point;
import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.factory.PieceImageFactory;
import com.androidmontreal.rhok.pieces.factory.PipeFactory;
import com.androidmontreal.rhok.renderers.BoardRenderer;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class WaterSupplyGame implements ApplicationListener {

	private static final int TABLE_HEIGHT = 6;
	private static final int TABLE_WIDTH = 5;
	private Pipe[][] pipesTable;
	
//	private SpriteBatch batch;
//	private Sprite sprite;

	private double steps;

	private List<Piece> pieces;
	
	private Hashtable<PipeType, Sprite> pipeSprites;
	private Board board;
	private BoardController boardController;
	private Stage sideboardStage;
	private Group group ;

	
	
	@Override
	public void create() {
		
		ScreenDims dims = new ScreenDims();
		
		// pipesTable = new Pipe[TABLE_WIDTH][TABLE_HEIGHT];
		
		board = new Board(TABLE_WIDTH, TABLE_HEIGHT);
		boardController = new BoardController(board, new BoardRenderer(),dims);

		System.out.println(dims.getWidth()+" "+ dims.getHeight());
		sideboardStage = new Stage(dims.getWidth(), dims.getHeight(), false);
//		sideboardStage.
		SideboardController sideboardController = new SideboardController(new Sideboard(), 0, 0, 100, 100){
			@Override
			public boolean touchDown(float x, float y, int pointer) {
				//System.out.println(String.format("sideboardcontroller Hit detect %f,%f", x, y));
				return super.touchDown(x, y, pointer);
			}
			
		};
//		sideboardStage.addActor(sideboardController);
//		
		// TEST
//		PieceController pieceController = new PieceController(new Pump(Direction.RIGHT, 5)) {
//			@Override
//			public boolean touchDown(float x, float y, int pointer) {
//				//System.out.println(String.format("piececontroller Hit detect %f,%f", x, y));
//				return true;
//			}
//		};
//		pieceController.touchable = true ;
//		sideboardStage.addActor(pieceController);
		// relative to parent here...
//		pieceController.setViewPosition(200,10);
		
		PieceImageFactory pieceImageFactory = new PieceImageFactory();
		Image pump = pieceImageFactory.buildPieceImage(new Pump(Direction.RIGHT, 5));
		pump.touchable=true;
		sideboardStage.addActor(pump);
		pump.x=200;
		pump.y=10;
		
		// For each new piece.
		// new PieceRenderer(p);
		
		// TODO: Remove this I think...
//		batch = new SpriteBatch();
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
		System.out.println(String.format("resized: %dx,%dy", width,height));

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
			Vector2 point = new Vector2();
            sideboardStage.toStageCoordinates(Gdx.input.getX(), Gdx.input.getY(), point);
            Actor actor = sideboardStage.hit(point.x, point.y);
            
            if(actor !=null){
            	System.out.println("actor != null");
            	if(actor instanceof PieceController){
            		System.out.println("POUPOUPOU");
            	}
            }
            else {
            	System.out.println("actor is null");
			}
            
            //System.out.println("Screen is touch at "+Gdx.input.getX()+";"+Gdx.input.getY());

            /*
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			Piece touchedPiece = boardController.findPiece(x, y);
			Point position = touchedPiece.getPosition();
			position.setX(x);
			position.setY(y);
			boardController.addPiece(touchedPiece, Gdx.input.getX(), Gdx.input.getY());
			*/
		}
		
		sideboardStage.draw();
		
		boardController.render() ;
		
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
