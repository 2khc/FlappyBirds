package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Pipe extends Parallax {
	private String pipePosition;

	public Pipe(Texture texture, float imageSpeed, String position) {
		super(texture, imageSpeed);
		this.positionY = (float) Math.random() * 800;
		this.pipePosition = position;
	}

	@Override
	protected void resetPositionX() {
		switch (this.pipePosition) {
		case "lower":
			this.positionY = (float) Math.random() * Gdx.graphics.getHeight();
			break;
		case "upper":
			this.positionY = 450 + (float) Math.random() * (Gdx.graphics.getHeight() - 405);
			break;
		default:
			this.positionY += 1;
		}

		super.resetPositionX();
	}
	
	
	// public void render() {
	// super.render(10, 10, Gdx.graphics.getWidth(), this.positionY);
	// }

}
