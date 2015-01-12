package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class LowerPipe implements IPipe {
	private Texture texture;
	public Vector2 position;

	public LowerPipe() {
		this.texture = new Texture(Gdx.files.internal("lowerpipe.png"));
		this.position = new Vector2();

	}

	public void init(float positionX, float positionY) {
		this.position.set(positionX, positionY);

	}

	public void draw(Batch batch, float xPosition, float yPosition) {
		batch.draw(this.texture, xPosition, yPosition, 78, 405);
	}
}
