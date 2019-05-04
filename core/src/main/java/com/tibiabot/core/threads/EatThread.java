package com.tibiabot.core.threads;

import com.tibiabot.core.logic.eater.EaterEngine;
import com.tibiabot.core.presentation.TibiaBot;

public class EatThread extends AbsThread implements Runnable {

    private EaterEngine eaterEngine;
    ThreadPool threadPool;

    public EatThread(EaterEngine eaterEngine, ThreadPool threadPool){

        this.eaterEngine = eaterEngine;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {

        while(true) {
            try {
                if (isOn()) {
                        Thread.sleep(60000);
                        eaterEngine.work();
                }else {
                    synchronized (this) {
                        wait();
                    }
                }
                }   catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
