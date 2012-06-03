package com.androidmontreal.rhok.renderers;

import java.util.ArrayList;

import com.androidmontreal.rhok.pieces.Pump;
import com.androidmontreal.rhok.pieces.factory.SpriteFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PumpRenderer implements IRenderer {

	private Pump p;
	private ArrayList<Sprite> sprites;
	private SpriteFactory sf;

	/**
	 * 
	 * @param p
	 */
	public PumpRenderer(Pump p) {

		this.p = p;
		sprites = new ArrayList<Sprite>();
		sf = SpriteFactory.getInstance();

		createBaseLayer();
		createComplexLayer();

	}


	/**
	 * Create the first layer
	 */
	private void createBaseLayer() {

		switch (p.getDirection()) {		
			case UP: sprites.add(sf.createSprite(SpriteFactory.PUMP_TOP)); break;
			case DOWN: sprites.add(sf.createSprite(SpriteFactory.PUMP_DOWN)); break;
			case RIGHT: sprites.add(sf.createSprite(SpriteFactory.PUMP_LEFT)); break;
			case LEFT: sprites.add(sf.createSprite(SpriteFactory.PUMP_RIGHT)); break;
		}
	}
	
	private void createComplexLayer() {
		// TODO Water related rendering go here
	}


	@Override
	public void render() {
		
		SpriteBatch batch = new SpriteBatch();
		
		for (Sprite s : sprites) {
			s.setPosition(p.getPosition().getX(),p.getPosition().getY());
			s.draw(batch);
		}
										
	}

}
