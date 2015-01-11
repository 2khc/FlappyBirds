package com.kelvin.flappybirds;

import com.badlogic.gdx.Game;

public class FlappyBirds extends Game {

	private IGameScreen gameScreen;

	@Override
	public void create() {
		gameScreen = new GameScreen();
		gameScreen.setGravity(5);
		this.setScreen(gameScreen);
	}

	@Override
	public void render() {
		super.render();
	}
}
