package com.tibiabot.core.presentation.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tibiabot.core.presentation.TibiaBot;
import javafx.scene.input.KeyEvent;

public class ConfigurationScreen implements Screen {

    private static final int row = 400/8;
    private static final int col = 400/8;

    private static int startHpY = 300;
    private static int startHpX = 100;
    private static int endHpY = 250;
    private static int endHpX = 100;
    private static int startManaY = 150;
    private static int startManaX = 100;
    private static int endManaY = 100;
    private static int endManaX = 100;
    private static int hpHotkeyX = 184;
    private static int hpHotkeyY = 273;
    private static int manaHotkeyX = 184;
    private static int manaHotkeyY = 124;



    private Texture background;

    Stage stage;
    Skin skin;

    TextField startHp;
    TextField endHp;
    TextField startMana;
    TextField endMana;
    TextField hpHotkey;
    TextField manaHotkey;
    TextField foodHotkey;
    TextField paralyzeHotkey;

    @Override
    public void render(float v) {

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            hpHotkey.setPosition(hpHotkey.getX(),hpHotkey.getY() + 1);
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            hpHotkey.setPosition(hpHotkey.getX(), hpHotkey.getY()-1);
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            hpHotkey.setPosition(hpHotkey.getX()+1, hpHotkey.getY());
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            hpHotkey.setPosition(hpHotkey.getX()-1, hpHotkey.getY());
        else if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
            System.out.println("X: " + hpHotkey.getX() + "          Y: " + hpHotkey.getY());

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background,0,0, TibiaBot.size,TibiaBot.size);
        stage.getBatch().end();
        stage.act();
        stage.draw();


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void show() {

        background = new Texture("niceBackground.jpg");

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("sgx/skin/sgx-ui.json"));

        startHp = new TextField("start HP", skin, "spinner");
        endHp = new TextField("end HP", skin, "spinner");

        startMana = new TextField("start MP", skin, "spinner");
        endMana = new TextField("end MP", skin, "spinner");

        hpHotkey = new TextField("HTK", skin, "spinner");
        manaHotkey = new TextField("HTK", skin, "spinner");

        hpHotkey.setPosition(hpHotkeyX,hpHotkeyY);
        manaHotkey.setPosition(manaHotkeyX,manaHotkeyY);

        startHp.setPosition(startHpX,startHpY);
        endHp.setPosition(endHpX,endHpY);
        startMana.setPosition(startManaX,startManaY);
        endMana.setPosition(endManaX,endManaY);

        hpHotkey.setWidth(50);
        manaHotkey.setWidth(50);

        endMana.setWidth(80);
        endHp.setWidth(80);
        startMana.setWidth(80);
        startHp.setWidth(80);

        stage.addActor(startMana);
        stage.addActor(startHp);
        stage.addActor(endHp);
        stage.addActor(endMana);
        stage.addActor(manaHotkey);
        stage.addActor(hpHotkey);
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
