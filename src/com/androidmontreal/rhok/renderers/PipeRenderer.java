package com.androidmontreal.rhok.renderers;

import java.util.ArrayList;

import com.androidmontreal.rhok.pieces.Pipe;
import com.androidmontreal.rhok.pieces.factory.SpriteFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PipeRenderer implements IRenderer {

	private Pipe p;
	private ArrayList<Sprite> sprites;
	private SpriteFactory sf;

	/**
	 * 
	 * @param p
	 */
	public PipeRenderer(Pipe p) {

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

		switch (p.getType()) {
		case TOP_LEFT:
			sprites.add(sf.createSprite(SpriteFactory.PIPE_TOP_LEFT));
			break;
		case TOP_RIGHT:
			sprites.add(sf.createSprite(SpriteFactory.PIPE_TOP_RIGHT));
			break;
		case DOWN_RIGHT:
			sprites.add(sf.createSprite(SpriteFactory.PIPE_DOWN_RIGHT));
			break;
		case DOWN_LEFT:
			sprites.add(sf.createSprite(SpriteFactory.PIPE_DOWN_LEFT));
			break;
		case HORIZONTAL:
			sprites.add(sf.createSprite(SpriteFactory.PIPE_HORIZONTAL));
			break;
		case VERTICAL:
			sprites.add(sf.createSprite(SpriteFactory.PIPE_VERTICAL));
			break;
		}
	}
	
	private void createComplexLayer() {
		
		// TODO Water related rendering go here
		
	}


	@Override
	public void render() {
		
		SpriteBatch batch = new SpriteBatch();
		
		batch.begin();
		for (Sprite s : sprites) {
			s.setPosition(p.getPosition().getX(),p.getPosition().getY());
			s.draw(batch);
		}
		batch.end();
										
	}

}
