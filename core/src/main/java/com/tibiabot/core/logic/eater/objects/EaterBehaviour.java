package com.tibiabot.core.logic.eater.objects;

import com.tibiabot.core.logic.common.abstractions.Abehaviour;

public class EaterBehaviour extends Abehaviour {

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    private int timer;


}
