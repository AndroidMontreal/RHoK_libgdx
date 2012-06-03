package com.androidmontreal.rhok.pieces.factory;

import com.androidmontreal.rhok.pieces.Piece;
import com.androidmontreal.rhok.pieces.PieceImage;
import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.WaterExit;
import com.androidmontreal.rhok.pieces.WaterSource;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PieceImageFactory {
	private SpriteFactory sf;

	private Sprite view;
	
	public PieceImageFactory() {
		this.sf = SpriteFactory.getInstance();
	}

	public Image buildPieceImage(Piece piece){
		return initView(piece);
	}
	
	// Set the sprite view to the right static image for the piece.
	Image initView(Piece piece) {
		if (piece instanceof Pipe) {
			Pipe pipe = (Pipe) piece;
			switch (pipe.getType()) {
			case TOP_LEFT:
				return new PieceImage(sf.createSprite(SpriteFactory.PIPE_TOP_LEFT).getTexture(),piece);
			case TOP_RIGHT:
				return new PieceImage(sf.createSprite(SpriteFactory.PIPE_TOP_RIGHT).getTexture(),piece);
			case DOWN_RIGHT:
				return new PieceImage(sf.createSprite(SpriteFactory.PIPE_DOWN_RIGHT).getTexture(),piece);
			case DOWN_LEFT:
				return new PieceImage(sf.createSprite(SpriteFactory.PIPE_DOWN_LEFT).getTexture(),piece);
			case HORIZONTAL:
				return new PieceImage(sf.createSprite(SpriteFactory.PIPE_HORIZONTAL).getTexture(),piece);
			case VERTICAL:
				return new PieceImage(sf.createSprite(SpriteFactory.PIPE_VERTICAL).getTexture(),piece);
			}

		} else if (piece instanceof Pump) {
			Pump pump = (Pump) piece;
			switch (pump.getDirection()) {
			case UP:
				return new PieceImage(sf.createSprite(SpriteFactory.PUMP_TOP).getTexture(),piece);
			case DOWN:
				return new PieceImage(sf.createSprite(SpriteFactory.PUMP_DOWN).getTexture(),piece);
			case RIGHT:
				//return new PieceImage(sf.createSprite(SpriteFactory.PUMP_LEFT));
				return new PieceImage(sf.createSprite(SpriteFactory.PUMP_LEFT).getTexture(),piece);
			case LEFT:
				return new PieceImage(sf.createSprite(SpriteFactory.PUMP_RIGHT).getTexture(),piece);
			}
		} else if (piece instanceof WaterSource) {
			return new PieceImage(sf.createSprite(SpriteFactory.WATER_SOURCE).getTexture(),piece);
		} else if (piece instanceof WaterExit) {
			return new PieceImage(sf.createSprite(SpriteFactory.WATER_EXIT).getTexture(),piece);
		}
		return null;

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
