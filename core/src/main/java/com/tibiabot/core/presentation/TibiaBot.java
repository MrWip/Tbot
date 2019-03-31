package com.tibiabot.core.presentation;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tibiabot.core.autowire.Autowire;
import com.tibiabot.core.logic.factories.Factory;
import com.tibiabot.core.presentation.screens.MenuScreen;
import com.tibiabot.core.presentation.screens.FeaturesScreen;
import com.tibiabot.core.threads.AmmoThread;
import com.tibiabot.core.threads.EatThread;
import com.tibiabot.core.threads.HealThread;
import com.tibiabot.core.threads.ThreadPool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TibiaBot extends Game {

	public static final int size = 400;

	private Factory botFactory;
	private Autowire autowire;
	private MenuScreen menu;
	private Screen features;

	private HealThread healThread;
	private EatThread eaterThread;
	private HealThread manaThread;
	private AmmoThread ammoThread;

	private boolean healerIsOn = false;
	private boolean potterIsOn = false;
	private boolean foodIsOn = false;
	private boolean ammoIsOn = false;
	private boolean paralyzeIsOn = false;


	private Batch batch;

	public Batch getBatch() {
		return batch;
	}

	@Override
	public void create () {
		this.autowire = new Autowire();
		try {
			botFactory = autowire.wireBot();

			//create the bot resources
			botFactory.createHpBehaviour(autowire.getHealerEngine(),95,75, KeyEvent.VK_F6);
			botFactory.createHpBehaviour(autowire.getHealerEngine(),75,  55,KeyEvent.VK_F7);
			botFactory.createHpBehaviour(autowire.getHealerEngine(),55,-1,KeyEvent.VK_F8);
			botFactory.createHpBehaviour(autowire.getHealerEngine(),30,-1,KeyEvent.VK_F11);
			botFactory.createHpBehaviour(autowire.getManaEngine(),40,-1,KeyEvent.VK_F10);
			botFactory.createManaBehaviour(autowire.getManaEngine(),70,-1,KeyEvent.VK_F11);
			botFactory.createEaterBehaviour(autowire.getEaterEngine(), 60000, KeyEvent.VK_F5);
			botFactory.createAmmoBehaviour(autowire.getAmmoEngine(), KeyEvent.VK_F4);
			botFactory.createParalizeBehaviour(autowire.getUtilEngine(), KeyEvent.VK_F6);

			ThreadPool threadPool = new ThreadPool();
			healThread = new HealThread(autowire.getHealerEngine(),threadPool);
			manaThread = new HealThread(autowire.getManaEngine(),threadPool);
			eaterThread = new EatThread(autowire, threadPool);
			ammoThread = new AmmoThread(autowire.getAmmoEngine(),threadPool);

			new Thread(healThread).start();
			new Thread(manaThread).start();
			new Thread(eaterThread).start();
			new Thread(ammoThread).start();

		} catch (AWTException e) {
			e.printStackTrace();
			System.out.println("Failed to wire bot");
		}
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
}
