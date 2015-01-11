package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.TimeUtils;

public abstract class Parallax implements IParallax {
	private Texture texture;
	private float currentBgX;
	private float lastTimeBg;
	private float imageSpeed;
	private float positionX;
	protected float positionY;
	private float width;
	private float height;

	public Parallax(Texture texture, float imageSpeed) {
		this.texture = texture;
		this.imageSpeed = imageSpeed;
		this.currentBgX = Gdx.graphics.getWidth();
		this.lastTimeBg = TimeUtils.nanoTime();
		this.positionY = (float) Math.random() * 800;
	}

	public void render(float width, float height, float positionX, float positionY) {
		this.width = width;
		this.height = height;
		this.positionX = positionX;
		this.positionY = positionY;

		if (TimeUtils.nanoTime() - lastTimeBg > 100000000) {
			this.currentBgX -= this.imageSpeed * Gdx.graphics.getDeltaTime();

			this.lastTimeBg = TimeUtils.nanoTime();
		}

		if (this.currentBgX <= 0) {
			resetPositionX();
		}
	}

	protected void resetPositionX() {
		this.currentBgX = Gdx.graphics.getWidth();
	}

	public float getCurrentBgX() {
		return this.currentBgX;
	}

	public float getPositionY() {
		return this.positionY;
	}

	public void draw(Batch batch) {
		batch.draw(texture, this.currentBgX - this.positionX, this.positionY, this.width, this.height);
		batch.draw(texture, this.currentBgX, this.positionY, this.width, this.height);
	}
}
