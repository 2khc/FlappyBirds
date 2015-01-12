package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface IMovingTexture {
	void update(float width, float height, float positionX, float positionY);

	abstract void draw(Batch batch);

	float getCurrentBgX();

	float getPositionY();
}
