package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class UpperPipe implements IPipe {
	private Texture texture;
	public Vector2 position;
	private Rectangle boxOne;
	private Rectangle boxTwo;
	private float pipeWidth;
	private float pipeHeight;

	public boolean alive;

	public UpperPipe() {
		this.texture = new Texture(Gdx.files.internal("upperpipe.png"));
		this.boxOne = new Rectangle();
		this.boxTwo = new Rectangle();
		this.position = new Vector2();
		this.pipeHeight = 405;
		this.pipeWidth = 78;
		this.alive = false;
	}

//	public void initRectangles(float positionX, float positionY) {
//		this.boxOne.height= t
//		this.boxOne.width = this.pipeWidth();
//				this.boxTwo
//	}
//
//	public void moveRectangles(float xPosition, float yPosition) {
//		this.boxOne.
//	}

	public void draw(Batch batch, float xPosition, float yPosition) {
		batch.draw(this.texture, xPosition, yPosition);
	}

	@Override
	public void init(float positionX, float positionY) {
		// TODO Auto-generated method stub
		
	}

}
