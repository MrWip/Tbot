package com.tibiabot.core.threads;

import com.tibiabot.core.logic.ammo.AmmoEngine;

public class AmmoThread extends AbsThread implements Runnable {

    ThreadPool threadPool;
    AmmoEngine ammoEngine;

    public AmmoThread(AmmoEngine ammoEngine, ThreadPool threadPool){

        this.threadPool = threadPool;
        this.ammoEngine = ammoEngine;
    }

    @Override
    public void run() {

        while(true) {
            if (isOn()) {
                try {
                    Thread.sleep(750);
                    ammoEngine.work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }}
        }
    }
}
