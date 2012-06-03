package com.androidmontreal.rhok.pieces.factory;

import java.util.Hashtable;

import com.androidmontreal.rhok.pieces.Piece;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteFactory {
	
	class SpriteKey {
		Class<Piece> clazz ;
	}
	
	private AssetManager am;
	
	private static SpriteFactory instance;
		
	public static String PUMP_TOP = "VerticalPump.png";
	public static String PUMP_DOWN = "VerticalPump.png";
	public static String PUMP_LEFT = "HorizontalPump.png";
	public static String PUMP_RIGHT = "HorizontalPump.png";
	public static String WATER_SOURCE = "Source.png";
	public static String WATER_SOURCE_1 = "water1.png";
	public static String WATER_SOURCE_2 = "water2.png";
	public static String WATER_EXIT = "Exit.png";
	public static String PIPE_TOP_LEFT = "TopLeft.png";
	public static String PIPE_TOP_RIGHT = "TopRight.png";
	public static String PIPE_DOWN_LEFT = "DownLeft.png";
	public static String PIPE_DOWN_RIGHT = "DownRight.png";
	public static String PIPE_HORIZONTAL = "HorizontalPipe.png";
	public static String PIPE_VERTICAL = "VerticalPipe.png";
	public static String BLANK = "blank.png";
	
	
	String[] assetImagePath = {			
			PUMP_TOP,
			PUMP_DOWN,
			PUMP_LEFT,
			PUMP_RIGHT,
			WATER_SOURCE,
			WATER_SOURCE_1,
			WATER_SOURCE_2,
			WATER_EXIT,
			PIPE_TOP_LEFT,
			PIPE_TOP_RIGHT,
			PIPE_DOWN_LEFT,
			PIPE_DOWN_RIGHT,
			PIPE_HORIZONTAL,
			PIPE_VERTICAL,
			BLANK
	};

	private Hashtable<String, Sprite> assets;
	

	private SpriteFactory() {		
		am = new AssetManager();
		loadAssets();
	}
	
	private void loadAssets() {		
		assets = new Hashtable<String, Sprite>();
		for (int i = 0; i < assetImagePath.length; i++) {
			assets.put(assetImagePath[i], new Sprite(new Texture(Gdx.files.internal(assetImagePath[i]))));
		}			
	}
	
	/**
	 * Return a sprite for a specified defined path, other wise blank
	 * @param asset
	 * @return
	 */
	public Sprite createSprite(String asset){
		if(assets.containsKey(asset)){
			return assets.get(asset);
		}else{
			return assets.get(BLANK);
		}
	}

	public static SpriteFactory getInstance() {
		
		if(instance==null){
			instance = new SpriteFactory();			
		}		
		return instance;
	}
	

}
