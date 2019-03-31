package com.tibiabot.core.logic.healer.objects;


import com.tibiabot.core.logic.common.abstractions.Abehaviour;

public class HealBehaviour extends Abehaviour{



    private int endX;
    private int endY;

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    @Override
    public String toString() {
        return "HealBehaviour{" +
                "endX=" + endX +
                ", endY=" + endY +
                "} " + super.toString();
    }
}


