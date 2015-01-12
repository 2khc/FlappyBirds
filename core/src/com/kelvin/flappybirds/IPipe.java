package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface IPipe {
	void init(float positionX, float positionY);
	void draw(Batch batch, float xPosition, float yPosition);
}
