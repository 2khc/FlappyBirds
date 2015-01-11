package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird implements IBird {
	private float x;
	private float y;
	private float speed;
	private float birdSpeed;
	private float gravity;
	
	private Texture bird;

	public Bird(Texture bird, float gravity) {
		this.bird = bird;
		this.gravity = gravity;
		this.speed = 0;
		this.birdSpeed = 4;
		setX(225 - this.bird.getWidth() / 2);
		setY(400);
	}

	public float getY() {
		return this.y;
	}

	public void setX(float x) {
		this.x = x;
	}	

	public void setY(float y) {
		this.y = y;
	}

	public void draw(Batch batch) {
		batch.draw(this.bird, this.x, this.y);
	}

	public void render() {
		this.speed -= this.gravity * Gdx.graphics.getDeltaTime();
		this.y += this.speed;
	}

	public void jump() {
		this.speed = this.birdSpeed;
	}
}
