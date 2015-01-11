package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface IParallax {
	void render(float width, float height, float positionX, float positionY);

	float getCurrentBgX();

	float getPositionY();

	void draw(Batch batch);
}
