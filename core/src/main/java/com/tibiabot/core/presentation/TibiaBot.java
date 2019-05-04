package com.tibiabot.core.presentation;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tibiabot.core.logic.ammo.AmmoEngine;
import com.tibiabot.core.logic.eater.EaterEngine;
import com.tibiabot.core.logic.factories.Factory;
import com.tibiabot.core.logic.healer.workers.HealerEngine;
import com.tibiabot.core.logic.paralize.ParalyzeEngine;
import com.tibiabot.core.presentation.screens.MenuScreen;
import com.tibiabot.core.presentation.screens.FeaturesScreen;
import com.tibiabot.core.threads.AmmoThread;
import com.tibiabot.core.threads.EatThread;
import com.tibiabot.core.threads.HealThread;
import com.tibiabot.core.threads.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TibiaBot extends Game {

	public static final int size = 400;

	@Autowired
	private Factory botFactory;

	private MenuScreen menu;
	private Screen features;

	@Autowired
	private HealerEngine healerEngine;
	@Autowired
	private AmmoEngine ammoEngine;
	@Autowired
	private EaterEngine eaterEngine;
	@Autowired
	private ParalyzeEngine paralyzeEngine;

	//since its a instance of healer engine it will be set on appContext.xml
	private HealerEngine manaEngine;

	private HealThread healThread;
	private EatThread eaterThread;
	private HealThread manaThread;
	private AmmoThread ammoThread;

	private boolean healerIsOn;
	private boolean potterIsOn ;
	private boolean foodIsOn;
	private boolean ammoIsOn;
	private boolean paralyzeIsOn;

	public TibiaBot(){

		this.healerIsOn = false;
		this.potterIsOn = false;
		this.foodIsOn = false;
		this.ammoIsOn = false;
		this.paralyzeIsOn = false;

		manaEngine = new HealerEngine();

	}


	private Batch batch;

	public Batch getBatch() {
		return batch;
	}

	@Override
	public void create () {

			//create the bot resources
			botFactory.createHpBehaviour(healerEngine,95,75, KeyEvent.VK_F6);
			botFactory.createHpBehaviour(healerEngine,75,  55,KeyEvent.VK_F7);
			botFactory.createHpBehaviour(healerEngine,55,-1,KeyEvent.VK_F8);
			botFactory.createHpBehaviour(healerEngine,30,-1,KeyEvent.VK_F11);
			botFactory.createHpBehaviour(healerEngine,40,-1,KeyEvent.VK_F10);
			botFactory.createManaBehaviour(manaEngine,70,-1,KeyEvent.VK_F11);
			botFactory.createEaterBehaviour(eaterEngine,60000, KeyEvent.VK_F5);
			botFactory.createAmmoBehaviour(ammoEngine, KeyEvent.VK_F4);
			botFactory.createParalizeBehaviour(paralyzeEngine, KeyEvent.VK_F6);

			ThreadPool threadPool = new ThreadPool();
			healThread = new HealThread(healerEngine,threadPool);
			manaThread = new HealThread(manaEngine, threadPool);
			eaterThread = new EatThread(eaterEngine, threadPool);
			ammoThread = new AmmoThread(ammoEngine,threadPool);

			new Thread(healThread).start();
			new Thread(manaThread).start();
			new Thread(eaterThread).start();
			new Thread(ammoThread).start();

		batch = new SpriteBatch();
		menu = new MenuScreen(this);
		features = new FeaturesScreen( batch,this);
		this.setScreen(menu);

	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {

		super.render();
		if(menu.isOn() && this.getScreen() != features)
			this.setScreen(features);
		 else if(!menu.isOn() && this.getScreen() != menu)
			this.setScreen(menu);

		 if (healerIsOn && !healThread.isOn()) {
		 	healThread.setOn(true);
		 	synchronized (healThread) { healThread.notifyAll(); }
		 }else if (!healerIsOn)
			 healThread.setOn(false);

		 if (potterIsOn && !manaThread.isOn()){
		 	manaThread.setOn(true);
		 	synchronized (manaThread) { manaThread.notifyAll(); }
		 }else if (!potterIsOn)
			 manaThread.setOn(false);

		 if (foodIsOn && !eaterThread.isOn()) {
		 	eaterThread.setOn(true);
		 	synchronized (eaterThread) { eaterThread.notifyAll(); }
		 }else if (!foodIsOn)
			 eaterThread.setOn(false);

		 if (ammoIsOn && !ammoThread.isOn()) {
		 	ammoThread.setOn(true);
		 	synchronized (ammoThread) { ammoThread.notifyAll(); }
		 } else if (!ammoIsOn)
		 	ammoThread.setOn(false);

	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}

	//setters for the on/off

	public void setHealerIsOn(boolean healerIsOn) {
		this.healerIsOn = healerIsOn;
	}

	public void setPotterIsOn(boolean potterIsOn) {
		this.potterIsOn = potterIsOn;
	}

	public void setFoodIsOn(boolean foodIsOn) {
		this.foodIsOn = foodIsOn;
	}

	public void setAmmoIsOn(boolean ammoIsOn) {
		this.ammoIsOn = ammoIsOn;
	}

	public void setParalyzeIsOn(boolean paralyzeIsOn) {
		this.paralyzeIsOn = paralyzeIsOn;
	}

	public MenuScreen getMenu() {
		return menu;
	}

	public void setManaEngine(HealerEngine manaEngine){

		this.manaEngine = manaEngine;
	}

}
