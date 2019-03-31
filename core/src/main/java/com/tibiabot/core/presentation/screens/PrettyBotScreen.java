package com.tibiabot.core.presentation.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.tibiabot.core.presentation.TibiaBot;

public class PrettyBotScreen implements Screen {

    private Game game;
    private Batch batch;

    private Texture on;
    private Texture off;
    private Texture background;
    private Texture healText;
    private Texture eaterText;
    private Texture ammoText;
    private Texture patalizeText;
    private Texture potterText;
    private Texture featuresText;

    //Pictures that change
    private Texture currentHealState;

    public static final int featureHeight = 32;
    public static final int featureWidth = 176;
    public static final int healerHeight = 39;
    public static final int healerWidth = 105;
    public static final int eaterHeight =30 ;
    public static final int eaterWidth = 80;
    public static final int rowY = 280;
    public static final int rowX = 80;
    public static final int utilityRowX = rowX ;
    public static final int utilityRowY = 133 ;
    public static final int btnStartWidth = 0;
    public static final int btnStartHeigt =0;

    public static final int onLightHeight = 29 ;
    public static final int onLightWidth = 39;

    public PrettyBotScreen(Game game, Batch batch){

        this.game = game;
        this.batch = batch;

    }

    @Override
    public void render(float v) {


        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(background,0,0, TibiaBot.size,TibiaBot.size);
        batch.draw(featuresText,TibiaBot.size/2-featureWidth/2, TibiaBot.size-20-featureHeight,featureWidth,featureHeight);
        batch.draw(healText, rowX, rowY,healerWidth,healerHeight);
        batch.draw(potterText,400-healerWidth,rowY,healerWidth,healerHeight);
        batch.draw(eaterText,rowX,utilityRowY, eaterWidth,eaterHeight);


        batch.end();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void show() {

        on = new Texture("FeatureOn.png");
        off = new Texture("FeatureOff.png");
        background = new Texture("niceBackground.jpg");
        featuresText = new Texture("features.png");
        healText = new Texture("healer.png");
        currentHealState = new Texture("green.png");
        potterText = new Texture("Potter.png");
        eaterText = new Texture("eater.png");
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
