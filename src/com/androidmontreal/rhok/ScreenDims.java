package com.androidmontreal.rhok;

import com.badlogic.gdx.Gdx;

public class ScreenDims {

	private int width;
	private int height;


	public ScreenDims() {
		this.refresh();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void refresh() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
	}
	
}
