package com.androidmontreal.rhok.control;

import com.androidmontreal.rhok.model.Sideboard;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class SideboardController extends Group {

	private final Sideboard model;
	
	private Sprite background ;

	public SideboardController(Sideboard model, int x, int y, int width, int height ) {
		super("Sideboard");
		// Init view elements 
		Texture texture = new Texture(Gdx.files.internal("level_00.png")); // FIXME: Need a proper 'texture' here (just an alpha tint background maybe?)
		background = new Sprite(texture);
		background.setPosition(x, y);
		background.setSize(width, height);
		
		this.model = model;
		
		// TODO: Create piece views for contained pieces?
	}
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		background.draw(batch);
		drawChildren(batch, parentAlpha);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor hit(float x, float y) {
		System.out.println("sideBoardController hited at : "+x+";"+y);
		return null;
	}

}
