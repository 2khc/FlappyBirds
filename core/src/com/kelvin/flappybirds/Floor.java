package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.Texture;

public class Floor extends Parallax {
	private Texture texture;
	private float imageSpeed;

	public Floor(Texture texture, float imageSpeed) {
		super(texture, imageSpeed);
	}
}
