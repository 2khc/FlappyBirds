package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.Texture;

public class Background extends Parallax {
	private Texture texture;
	private float imageSpeed;
	public Background(Texture texture, float imageSpeed) {
		super(texture,imageSpeed);
	}
}
