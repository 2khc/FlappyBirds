package com.kelvin.flappybirds.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kelvin.flappybirds.FlappyBirds;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Flappy Birds";
		config.width = 450;
		config.height = 800;
		new LwjglApplication(new FlappyBirds(), config);
	}
}
