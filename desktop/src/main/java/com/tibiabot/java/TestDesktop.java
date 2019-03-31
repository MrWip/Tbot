package com.tibiabot.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.tibiabot.core.presentation.SimpleGame;
import com.tibiabot.core.presentation.TibiaBot;

public class TestDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.foregroundFPS = 1;
		//config.backgroundFPS = 2;
		config.height = TibiaBot.size;
		config.width = TibiaBot.size;
		//new LwjglApplication(new TibiaBot(), config);
		new LwjglApplication(new SimpleGame(), config);
	}
}
