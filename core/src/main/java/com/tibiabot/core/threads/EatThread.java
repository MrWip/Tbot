package com.tibiabot.core.threads;

import com.tibiabot.core.autowire.Autowire;
import com.tibiabot.core.presentation.TibiaBot;

public class EatThread extends AbsThread implements Runnable {

    private Autowire autowire;
    private TibiaBot bot;
    ThreadPool threadPool;

    public EatThread(Autowire autowire,ThreadPool threadPool){

        this.autowire = autowire;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {

        while(true) {
            try {
                if (isOn()) {
                        Thread.sleep(60000);
                        autowire.getEaterEngine().work();
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
