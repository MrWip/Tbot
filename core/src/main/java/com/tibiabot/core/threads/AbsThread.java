package com.tibiabot.core.threads;

public abstract class AbsThread  {

    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
