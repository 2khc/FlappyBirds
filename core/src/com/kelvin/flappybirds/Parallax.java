package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Parallax extends MovingTexture implements IParallax {

	public Parallax(Texture texture, float imageSpeed, float xResetValue) {
		super(texture, imageSpeed, xResetValue);

		this.currentBgX = Gdx.graphics.getWidth();

		this.positionY = (float) Math.random() * 800;
	}

	public void draw(Batch batch) {
		batch.draw(this.texture, this.currentBgX - this.offsetX, this.positionY, this.width, this.height);
		batch.draw(this.texture, this.currentBgX, this.positionY, this.width, this.height);
	}
}
