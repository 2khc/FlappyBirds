package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements IGameScreen {
	private Batch batch;
	private IParallax background;
	private IParallax floor;
	private IParallax upperPipe;
	private IParallax lowerPipe;
	private IBird bird;
	private OrthographicCamera camera;
	private float gravity;
	private float randomY;
	private float floorHeight;
	private float floorSpeed;
	private float backgroundSpeed;

	public GameScreen() {
		this.gravity = 5;
		this.floorHeight = 200;
		this.backgroundSpeed = 7;
		this.floorSpeed = 100;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public void setFloorHeight(float floorHeight) {
		this.floorHeight = floorHeight;
	}

	@Override
	public void show() {

		batch = new SpriteBatch();
		background = new Background(new Texture(Gdx.files.internal("background.png")), this.backgroundSpeed);
		floor = new Floor(new Texture(Gdx.files.internal("floor.png")), this.floorSpeed);
		bird = new Bird(new Texture(Gdx.files.internal("smallangrybird.png")), this.gravity);
		upperPipe = new Pipe(new Texture(Gdx.files.internal("upperpipe.png")), this.floorSpeed, "upper");

		lowerPipe = new Pipe(new Texture(Gdx.files.internal("lowerpipe.png")), this.floorSpeed, "lower");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 450, 800);

		Gdx.input.setInputProcessor(new Controller(bird));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Create textures
		background.render(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), 0);
		floor.render(Gdx.graphics.getWidth(), this.floorHeight, Gdx.graphics.getWidth(), 0);
		bird.render();
		System.out.println(upperPipe.getCurrentBgX());

		upperPipe.render(78, 405, Gdx.graphics.getWidth(), upperPipe.getPositionY());

		// Start drawing
		batch.begin();
		background.draw(batch);
		floor.draw(batch);
		upperPipe.draw(batch);
		bird.draw(batch);
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
