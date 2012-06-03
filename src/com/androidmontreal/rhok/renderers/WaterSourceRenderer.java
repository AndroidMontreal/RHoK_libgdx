package com.androidmontreal.rhok.renderers;

import java.util.ArrayList;

import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.WaterSource;
import com.androidmontreal.rhok.pieces.factory.SpriteFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WaterSourceRenderer implements IRenderer {

	private WaterSource w;
	private ArrayList<Sprite> sprites;
	private SpriteFactory sf;

	/**
	 * 
	 * @param p
	 */
	public WaterSourceRenderer(WaterSource w) {

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
		sprites.add(sf.createSprite(SpriteFactory.WATER_SOURCE));
	}
	
	private void createComplexLayer() {
		
		if(System.currentTimeMillis()%1000>500){
			sprites.add(sf.createSprite(SpriteFactory.WATER_SOURCE_1));
		}else{
			sprites.add(sf.createSprite(SpriteFactory.WATER_SOURCE_2));
		}
		
		// TODO Water related rendering go here
	}


	@Override
	public void render() {
		
		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		for (Sprite s : sprites) {
			s.setPosition(w.getPosition().getX(),w.getPosition().getY());
			
			
			//s.setRotation(d);
			s.draw(batch);
		}
		batch.end();
										
	}

}
