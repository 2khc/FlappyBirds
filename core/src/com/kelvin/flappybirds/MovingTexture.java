package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.TimeUtils;

public abstract class MovingTexture implements IMovingTexture {
	protected Texture texture;
	private float imageSpeed;
	private float lastTimeBg;
	protected float offsetX;
	protected float positionY;
	protected float width;
	protected float height;
	private float xResetValue;
	protected float currentBgX;

	public MovingTexture(Texture texture, float imageSpeed, float xResetValue) {
		this.texture = texture;
		this.imageSpeed = imageSpeed;
		this.lastTimeBg = TimeUtils.nanoTime();
		this.xResetValue = xResetValue;
		this.currentBgX = Gdx.graphics.getWidth();
	}

	public void update(float width, float height, float offsetX, float positionY) {
		this.width = width;
		this.height = height;
		this.offsetX = offsetX;
		this.positionY = positionY;

		if (TimeUtils.nanoTime() - lastTimeBg > 100000000) {
			this.currentBgX -= this.imageSpeed * Gdx.graphics.getDeltaTime();

			this.lastTimeBg = TimeUtils.nanoTime();
		}

		if (this.currentBgX <= xResetValue) {
			resetPositionX();
		}
	}


	public float getCurrentBgX() {
		return this.currentBgX;
	}

	public float getPositionY() {
		return this.positionY;
	}

	protected void resetPositionX() {
		this.currentBgX = Gdx.graphics.getWidth();
	}

	public abstract void draw(Batch batch);

}
