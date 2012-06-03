package com.androidmontreal.rhok.renderers;

import java.util.ArrayList;

import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.WaterExit;
import com.androidmontreal.rhok.pieces.WaterSource;
import com.androidmontreal.rhok.pieces.factory.SpriteFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WaterExitRenderer implements IRenderer {

	private WaterSource w;
	private ArrayList<Sprite> sprites;
	private SpriteFactory sf;

	/**
	 * 
	 * @param p
	 */
	public WaterExitRenderer(WaterExit p) {

		this.w = w;
		sprites = new ArrayList<Sprite>();
		sf = SpriteFactory.getInstance();

		createBaseLayer();
		createComplexLayer();

	}


	/**
	 * Create the first layer
	 */
	private void createBaseLayer() {
		sprites.add(sf.createSprite(SpriteFactory.WATER_EXIT));
	}
	
	private void createComplexLayer() {
		// TODO Water related rendering go here
	}


	@Override
	public void render() {
		
		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		for (Sprite s : sprites) {
			s.setPosition(w.getPosition().getX(),w.getPosition().getY());
			s.draw(batch);
		}
		batch.end();
										
	}

}
