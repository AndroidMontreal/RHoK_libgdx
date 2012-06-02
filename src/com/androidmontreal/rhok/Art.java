package com.androidmontreal.rhok;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Art {
	
	public static Texture texture;

	public static void load() {
		texture = new Texture(Gdx.files.internal("nh-01.png"));
	}

}
