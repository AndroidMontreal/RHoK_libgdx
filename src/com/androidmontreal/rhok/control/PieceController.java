package com.androidmontreal.rhok.control;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.WaterExit;
import com.androidmontreal.rhok.pieces.WaterSource;
import com.androidmontreal.rhok.pieces.factory.SpriteFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PieceController extends Actor {
	private SpriteFactory sf;

	private Piece piece ;
	private Sprite view ;
	
	public PieceController(Piece piece) {
		this.sf = SpriteFactory.getInstance();
		this.piece = piece;
		this.initView();
		// Initial values...
		this.width = view.getWidth() ;
		this.height = view.getHeight();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		view.setSize(width, height);
		view.draw(batch);
	}

	@Override
	public Actor hit(float x, float y) {
		System.out.println(String.format("pieceController Hit detect %f,%f", x, y));
		return x > this.x && x < width+this.x && y > this.y && y < height + this.y ? this : null;
//		return x > 0 && x < width && y > 0 && y < height ? this : null;
	}
	
	// Set the sprite view to the right static image for the piece.
	void initView() {
		if( this.piece instanceof Pipe ) {
			Pipe pipe = (Pipe) piece ;
			switch( pipe.getType() ) {
				case TOP_LEFT:
					view =(sf.createSprite(SpriteFactory.PIPE_TOP_LEFT));
					break;
				case TOP_RIGHT:
					view =(sf.createSprite(SpriteFactory.PIPE_TOP_RIGHT));
					break;
				case DOWN_RIGHT:
					view =(sf.createSprite(SpriteFactory.PIPE_DOWN_RIGHT));
					break;
				case DOWN_LEFT:
					view =(sf.createSprite(SpriteFactory.PIPE_DOWN_LEFT));
					break;
				case HORIZONTAL:
					view =(sf.createSprite(SpriteFactory.PIPE_HORIZONTAL));
					break;
				case VERTICAL:
					view =(sf.createSprite(SpriteFactory.PIPE_VERTICAL));
					break;
			}
			
		} else if( this.piece instanceof Pump ) {
			Pump pump = (Pump) piece ;
			switch( pump.getDirection() ) {
				case UP: view = (sf.createSprite(SpriteFactory.PUMP_TOP)); break;
				case DOWN: view =(sf.createSprite(SpriteFactory.PUMP_DOWN)); break;
				case RIGHT: view =(sf.createSprite(SpriteFactory.PUMP_LEFT)); break;
				case LEFT: view =(sf.createSprite(SpriteFactory.PUMP_RIGHT)); break;
			}
		} else if( this.piece instanceof WaterSource ) {
			view = (sf.createSprite(SpriteFactory.WATER_SOURCE));
		} else if( this.piece instanceof WaterExit ) {
			view = (sf.createSprite(SpriteFactory.WATER_EXIT));
		} 

	}

	/** 
	 * Exposed mostly for use by other controllers.
	 * @param x
	 * @param y
	 */
	public void setViewPosition(float x, float y) {
		this.x = x ;
		this.y = y ;
		view.setPosition(x, y);
	}

}
