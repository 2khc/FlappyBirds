package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface IPipeSet {
	void init(float yPosition);

	boolean getAlive();

	void draw(Batch batch);

	void update(float delta);
}
