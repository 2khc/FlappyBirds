package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface IBird {
	void jump();

	void draw(Batch batch);

	float getY();

	void setX(float x);

	void render();

	void setY(float y);
}
