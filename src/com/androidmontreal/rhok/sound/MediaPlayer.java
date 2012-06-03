package com.androidmontreal.rhok.sound;

import java.util.HashMap;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;


public class MediaPlayer {
		
	private Audio audio;
	private Sound pumpSound;

	private MediaPlayer() {

		HashMap<Integer, String> soundList = new HashMap<Integer, String>();
		audio = Gdx.audio;
		pumpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/pump.mp3"));
	}
		
	private static MediaPlayer instance;

	public static MediaPlayer getInstance(){
		
		if(instance==null){
			instance = new MediaPlayer();
		}
		return instance;		
	}
	
	
	/**
	 * @param id
	 * @param loop
	 * @param disposeAfterPlay
	 */
	public void play(int id, boolean loop, boolean disposeAfterPlay){
		
		pumpSound.play();
		
	}
	
	
	

}
