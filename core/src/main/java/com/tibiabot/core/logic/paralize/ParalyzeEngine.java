package com.tibiabot.core.logic.paralize;

import com.tibiabot.core.logic.common.SimpleBehaviour;
import com.tibiabot.core.logic.common.abstractions.Aworker;
import com.tibiabot.core.logic.common.resources.BotConfig;

public class ParalyzeEngine extends Aworker<SimpleBehaviour>{

    private final int checkTimes = 80;


    @Override
    public void work() {
        int i = 0;
        int color;

        while(i< checkTimes){
            color = getRobot().getPixelColor(BotConfig.paralizeStartX + i,BotConfig.paralizeSartY).getRGB();
            for (SimpleBehaviour s : getList()){
                if(color == s.getColor()){
                    synchronized (getTibiaInputer()){
                        getTibiaInputer().cast(s);
                    }
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
            i=i+10;
        }
    }
}
