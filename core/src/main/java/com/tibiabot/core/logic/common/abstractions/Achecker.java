package com.tibiabot.core.logic.common.abstractions;

import com.tibiabot.core.logic.common.interfaces.Ichecker;
import org.springframework.beans.factory.annotation.Autowired;


import java.awt.*;

public abstract class Achecker<T extends Abehaviour> implements Ichecker<T> {

    @Autowired
    private Robot robot;

    public Robot getRobot() {
        return robot;
    }

    public boolean check(T behaviour) {

        return robot.getPixelColor(behaviour.getStartX(), behaviour.getStartY()).getRGB() == behaviour.getColor();

    }

    public void setRobot(Robot robot) {
        this.robot = robot;

    }


}
