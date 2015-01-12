package com.kelvin.flappybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;

public class GameScreen implements IGameScreen {
	private Batch batch;
	private IParallax background;
	private IParallax floor;
	// private IPipe upperPipe;
	// private IPipe lowerPipe;

	private IPipePool pipePool;
	private IBird bird;
	private OrthographicCamera camera;
	private float gravity;

	private float floorHeight;
	private float floorSpeed;
	private float backgroundSpeed;

	// private FPSLogger fpsLogger;

	public GameScreen() {
		this.gravity = 5;
		this.floorHeight = 200;
		this.backgroundSpeed = 7;
		this.floorSpeed = 200; // previously 200 with dt
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public void setFloorHeight(float floorHeight) {
		this.floorHeight = floorHeight;
	}

	@Override
	public void show() {
		// fpsLogger = new FPSLogger();
		batch = new SpriteBatch();
		background = new Background(new Texture(Gdx.files.internal("background.png")), this.backgroundSpeed, 0);
		floor = new Floor(new Texture(Gdx.files.internal("floor.png")), this.floorSpeed, 0);
		bird = new Bird(new Texture(Gdx.files.internal("angrybird.png")), this.gravity);
		pipePool = new PipePool();
//		pipePool.init();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 450, 800);

		Gdx.input.setInputProcessor(new Controller(bird));
	}

	@Override
	public void render(float delta) {

		// fpsLogger.log();

		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Create textures
		background.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), 0);
		floor.update(Gdx.graphics.getWidth(), this.floorHeight, Gdx.graphics.getWidth(), 0);
		bird.update();
		pipePool.update(delta);
		// upperPipe.render(78, 405, 0, upperPipe.getPositionY());

		// Start drawing
		batch.begin();
		background.draw(batch);
		floor.draw(batch);
		pipePool.draw(batch);
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
