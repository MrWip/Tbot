package com.tibiabot.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.tibiabot.core.presentation.SimpleGame;
import com.tibiabot.core.presentation.TibiaBot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.foregroundFPS = 1;
		//config.backgroundFPS = 2;
		ApplicationContext ctx = new FileSystemXmlApplicationContext("/core/conf/appContext.xml");


		config.height = TibiaBot.size;
		config.width = TibiaBot.size;
		//new LwjglApplication(new TibiaBot(), config);
		new LwjglApplication((TibiaBot)ctx.getBean("bot"), config);
	}
}
