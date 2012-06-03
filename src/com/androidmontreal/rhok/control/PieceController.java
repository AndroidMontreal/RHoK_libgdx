package com.androidmontreal.rhok.control;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.WaterExit;
import com.androidmontreal.rhok.pieces.WaterSource;
import com.androidmontreal.rhok.pieces.factory.SpriteFactory;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PieceController extends Image {
	private SpriteFactory sf;

	private Piece piece;
	private Sprite view;

	public PieceController(Piece piece) {
		this.initView(piece);
		this.sf = SpriteFactory.getInstance();
		this.piece = piece;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		view.draw(batch);
	}

	@Override
	public Actor hit(float x, float y) {
		System.out.println(String.format("Piece Controller hited %f,%f", x, y));
		// TODO Auto-generated method stub
		return this;
	}

	// Set the sprite view to the right static image for the piece.
	void initView(Piece piece2) {
		if (piece2 instanceof Pipe) {
			Pipe pipe = (Pipe) piece2;
			switch (pipe.getType()) {
			case TOP_LEFT:
				view = (sf.createSprite(SpriteFactory.PIPE_TOP_LEFT));
				break;
			case TOP_RIGHT:
				view = (sf.createSprite(SpriteFactory.PIPE_TOP_RIGHT));
				break;
			case DOWN_RIGHT:
				view = (sf.createSprite(SpriteFactory.PIPE_DOWN_RIGHT));
				break;
			case DOWN_LEFT:
				view = (sf.createSprite(SpriteFactory.PIPE_DOWN_LEFT));
				break;
			case HORIZONTAL:
				view = (sf.createSprite(SpriteFactory.PIPE_HORIZONTAL));
				break;
			case VERTICAL:
				view = (sf.createSprite(SpriteFactory.PIPE_VERTICAL));
				break;
			}

		} else if (piece2 instanceof Pump) {
			Pump pump = (Pump) piece2;
			switch (pump.getDirection()) {
			case UP:
				view = (sf.createSprite(SpriteFactory.PUMP_TOP));
				break;
			case DOWN:
				view = (sf.createSprite(SpriteFactory.PUMP_DOWN));
				break;
			case RIGHT:
				//view = (sf.createSprite(SpriteFactory.PUMP_LEFT));
				//this(sf.createSprite(SpriteFactory.PUMP_LEFT).getTexture());
				break;
			case LEFT:
				view = (sf.createSprite(SpriteFactory.PUMP_RIGHT));
				break;
			}
		} else if (this.piece instanceof WaterSource) {
			view = (sf.createSprite(SpriteFactory.WATER_SOURCE));
		} else if (this.piece instanceof WaterExit) {
			view = (sf.createSprite(SpriteFactory.WATER_EXIT));
		}

	}

	/**
	 * Exposed mostly for use by other controllers.
	 * 
	 * @param x
	 * @param y
	 */
	public void setViewPosition(float x, float y) {
		view.setPosition(x, y);
	}

}
