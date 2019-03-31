package com.tibiabot.core.presentation;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tibiabot.core.presentation.screens.ConfigurationScreen;
import com.tibiabot.core.presentation.screens.FeaturesScreen;

public class SimpleGame extends Game {

    ConfigurationScreen featuresScreen;
    Batch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        featuresScreen = new ConfigurationScreen();
        this.setScreen(featuresScreen);
    }

}
