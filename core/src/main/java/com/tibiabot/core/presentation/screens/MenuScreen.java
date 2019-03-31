package com.tibiabot.core.presentation.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.tibiabot.core.presentation.TibiaBot;

public class MenuScreen implements Screen {

    private static final int btnSize = 100;
    private static final int LOGOWIDTH = 200;
    private static final int LOGOHEIGHT = 100;

    private TibiaBot game;
    private boolean isOn;
    private Texture onButton;
    private Texture offButton;
    private Texture botLogo;
    private Texture currentTexture;
    float x;
    float y;

    public MenuScreen(TibiaBot game){

        this.game=game;

    }


    @Override
    public void render(float v) {

        if(Gdx.input.getX() >= TibiaBot.size/2 - btnSize/2 && Gdx.input.getX()<= (TibiaBot.size/2 - btnSize/2) + btnSize &&
                Gdx.input.getY() >= TibiaBot.size/2 - btnSize/2 && Gdx.input.getY() <= (TibiaBot.size/2 - btnSize/2) + btnSize  )
        {
            if(Gdx.input.isTouched()){
                if(currentTexture == offButton){
                    currentTexture = onButton;
                    isOn = true;
                }else{
                    currentTexture = offButton;
                    isOn = false;
                }
            }
        }

        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(botLogo,TibiaBot.size/2 - LOGOWIDTH/2 ,TibiaBot.size - LOGOHEIGHT - TibiaBot.size/64,LOGOWIDTH,LOGOHEIGHT);
        game.getBatch().draw(currentTexture, TibiaBot.size/2 - btnSize/2, TibiaBot.size/2 - btnSize/2, btnSize, btnSize);

        game.getBatch().end();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void show() {

        onButton = new Texture("on.png");
        offButton = new Texture("off.png");
        botLogo = new Texture("tibia.png");
        currentTexture = offButton;
        isOn = false;

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

    public boolean isOn() {
        return isOn;
    }
}
