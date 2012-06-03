package com.androidmontreal.rhok.renderers;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The board knows it's renderer... we should create a controller but no time!
 *
 */
public class BoardRenderer implements IRenderer {
	
	private List<IRenderer> pieceRenderers = new ArrayList<IRenderer>();
	
	public BoardRenderer() {
	}

	public void addPieceRenderer(IRenderer renderer) {
		pieceRenderers.add(renderer);
	}

	public void clear() {
		pieceRenderers.clear();
	}

	public boolean contains(Object o) {
		return pieceRenderers.contains(o);
	}

	public boolean remove(Object o) {
		return pieceRenderers.remove(o);
	}
	
	public void render(  ) {
		for(IRenderer current : pieceRenderers) {
			current.render();
		}
	}
}
