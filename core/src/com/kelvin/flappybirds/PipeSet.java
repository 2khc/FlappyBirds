package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Pool.Poolable;

public class PipeSet implements Poolable, IPipeSet {
	private IPipe lowerPipe;
	private IPipe upperPipe;
	private Vector2 position;
	private boolean alive;
	private float lastTime;

	public PipeSet() {
		this.position = new Vector2();
		this.lowerPipe = new LowerPipe();
		this.upperPipe = new UpperPipe();
	}

	public void init(float yPosition) {
		this.position.x = Gdx.graphics.getWidth();
		this.position.y = yPosition;
		this.alive = true;
	}

	@Override
	public void reset() {
		this.position.set(0, 0);
		this.alive = false;
	}

	public boolean getAlive() {
		return this.alive;
	}

	public void update(float delta) {
	
		// if bullet is out of screen, set it to dead
		if (this.position.x < 0 - 78) {
			this.alive = false;
			System.out.println("this.alive is: " + this.alive);
		}

		if (TimeUtils.nanoTime() - this.lastTime > 100000000) {
			this.position.x -= 200 * delta;

			this.lastTime = TimeUtils.nanoTime();
		}

	}

	public void draw(Batch batch) {
		this.upperPipe.draw(batch, this.position.x, this.position.y);
		this.lowerPipe.draw(batch, this.position.x, this.position.y - 70 - 450);
	}
}
