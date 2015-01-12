package com.kelvin.flappybirds;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.TimeUtils;

public class PipePool implements IPipePool {
	private IPipeSet item;
	private int length;
	private float time = TimeUtils.nanoTime() / 1000000000;

	private final Array<IPipeSet> activePipes = new Array<IPipeSet>();
	private final Pool<IPipeSet> pipePool = new Pool<IPipeSet>() {
		@Override
		protected PipeSet newObject() {
			return new PipeSet();
		}
	};

//	public void init() {
//		this.item = pipePool.obtain();
//		this.item.init(400);
//		// this.length = 1;
//	}

	public void update(float delta) {

		IPipeSet item;
		if (TimeUtils.nanoTime() / 1000000000 - this.time > 2) {
			item = this.pipePool.obtain();
			System.out.println(item);
			item.init(300 + (float) Math.random() * 300);
			this.activePipes.add(item);
			this.time = TimeUtils.nanoTime() / 1000000000;
			System.out.println("added");
			System.out.println(this.activePipes.size);
		}

		for (int i = 0; i < this.activePipes.size; i++) {
			this.activePipes.get(i).update(delta);
		}

		this.length = activePipes.size;

		for (int i = length; --i >= 0;) {

			item = activePipes.get(i);

			if (item.getAlive() == false) {
				activePipes.removeIndex(i);
				pipePool.free(item);
				System.out.print("freed");
			}
		}
	}

	public void draw(Batch batch) {
		for (int i = 0; i < this.activePipes.size; i++) {
			this.activePipes.get(i).draw(batch);
		}
	}

}
