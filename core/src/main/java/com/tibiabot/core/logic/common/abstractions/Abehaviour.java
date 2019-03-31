package com.tibiabot.core.logic.common.abstractions;

public abstract class Abehaviour {

    private int startX;
    private int startY;
    private int hotkey;
    private int color;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getHotkey() {
        return hotkey;
    }

    public void setHotkey(int hotkey) {
        this.hotkey = hotkey;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Abehaviour{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", hotkey=" + hotkey +
                ", color=" + color +
                '}';
    }
}
