package com.tibiabot.core.presentation.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tibiabot.core.presentation.SimpleGame;
import com.tibiabot.core.presentation.TibiaBot;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

public class FeaturesScreen implements Screen {

    private static final int row = 400/8;
    private static final int col = 400/8;

    private TibiaBot tbot;
    private SimpleGame game;

    Stage stage;
    ScreenViewport viewport;
    Batch batch;
    Skin skin;
    Button healBtn;
    Button potBtn;
    Button foodBtn;
    Button ammoBtn;
    Button paralyzeBtn;
    Button home;
    Label healLabel;
    Label potLabel;
    Label paralyzeLabel;
    Label ammoLabel;
    Label foodLabel;
    TextureRegionDrawable on;
    TextureRegionDrawable off;
    public FeaturesScreen(Batch batch, TibiaBot tbot){

        this.batch = batch;
        this.tbot = tbot;

    }

    public FeaturesScreen(Batch batch, SimpleGame simpleGame){

        this.batch = batch;
        this.game = simpleGame;

    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if(home.isChecked()){

            //change the screen to render
            tbot.setScreen(tbot.getMenu());

            home.setChecked(false);

            //stop the threads
            tbot.setParalyzeIsOn(false);
            tbot.setAmmoIsOn(false);
            tbot.setFoodIsOn(false);
            tbot.setPotterIsOn(false);
            tbot.setHealerIsOn(false);

            this.dispose();

            return;
        }

        //checks for the switches
        if(healBtn.isChecked())
            tbot.setHealerIsOn(true);
        else if (!healBtn.isChecked())
            tbot.setHealerIsOn(false);
        if(potBtn.isChecked())
            tbot.setPotterIsOn(true);
        else if(!potBtn.isChecked())
            tbot.setPotterIsOn(false);
        if(ammoBtn.isChecked())
            tbot.setAmmoIsOn(true);
        else if(!ammoBtn.isChecked())
            tbot.setAmmoIsOn(false);
        if(foodBtn.isChecked())
            tbot.setFoodIsOn(true);
        else if(!foodBtn.isChecked())
            tbot.setFoodIsOn(false);
        if(paralyzeBtn.isChecked())
            tbot.setParalyzeIsOn(true);
        else if(!paralyzeBtn.isChecked())
            tbot.setParalyzeIsOn(false);

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void show() {

        System.out.println("now");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("sgx/skin/sgx-ui.json"));

        on = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("green.png"))));
        off = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("red.png"))));

        //healer switch and label
        healLabel = new Label("Healer", skin);
        healBtn = new Button(skin,"switch");

        healLabel.setPosition(20, row*2);
        healBtn.setPosition(col*2,row*2);

        stage.addActor(healLabel);
        stage.addActor(healBtn);

        //potter switch and label
        potLabel = new Label("Potter", skin);
        potBtn = new Button(skin,"switch");

        potLabel.setPosition(col, row*3);
        potBtn.setPosition(col*3,row*3);

        stage.addActor( potLabel);
        stage.addActor(potBtn);

        //food switch and label
        foodLabel = new Label("Food", skin);
        foodBtn = new Button(skin,"switch");

        foodLabel.setPosition(2*col, 4*row);
        foodBtn.setPosition(4*col, 4*row);

        stage.addActor(foodLabel);
        stage.addActor(foodBtn);

        //paralyze switch and label
        paralyzeLabel = new Label("Paralyze", skin);
        paralyzeBtn = new Button(skin, "switch");

        paralyzeLabel.setPosition(3*col, 5*row);
        paralyzeBtn.setPosition(5*col,5*row);

        stage.addActor(paralyzeLabel);
        stage.addActor(paralyzeBtn);

        //ammo switch and label
        ammoLabel = new Label("Ammo", skin);
        ammoBtn = new Button(skin,"switch");

        ammoLabel.setPosition(4*col, 6*row);
        ammoBtn.setPosition(6*col,6*row);

        stage.addActor(ammoLabel);
        stage.addActor(ammoBtn);

        home = new Button(skin, "close");
        home.setPosition(col,row*7);
        stage.addActor(home);

        /*final TextButton button2 = new TextButton("Radio Button",skin,"small");
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
               button2.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                button2.setText("Pressed Text Button");
                return true;
            }
        });*/

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
