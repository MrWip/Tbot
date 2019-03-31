package com.tibiabot.core.threads;

import com.tibiabot.core.autowire.Autowire;
import com.tibiabot.core.logic.healer.workers.HealerEngine;
import com.tibiabot.core.presentation.TibiaBot;

public class HealThread extends AbsThread implements Runnable {

    ThreadPool threadPool;
    HealerEngine healerEngine;

    public HealThread(HealerEngine healerEngine, ThreadPool threadPool){

        this.threadPool = threadPool;
        this.healerEngine = healerEngine;
    }

    @Override
    public void run() {

     while(true) {
         if (isOn()) {
                     healerEngine.work();
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
