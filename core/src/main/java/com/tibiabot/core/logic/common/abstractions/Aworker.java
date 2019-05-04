package com.tibiabot.core.logic.common.abstractions;

import com.tibiabot.core.logic.common.TibiaInputer;
import com.tibiabot.core.logic.common.interfaces.IWorker;
import org.springframework.beans.factory.annotation.Autowired;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Aworker<T extends Abehaviour> implements IWorker {

    @Autowired
    private Robot robot;
    @Autowired
    private TibiaInputer tibiaInputer;

    private List<T> list;



    //Getters and setters
    public Robot getRobot() { return robot; }
    public void setRobot(Robot robot) { this.robot = robot; }
    public TibiaInputer getTibiaInputer() { return tibiaInputer; }
    public void setTibiaInputer(TibiaInputer tibiaInputer) { this.tibiaInputer = tibiaInputer; }
    public List<T> getList() { return list; }

    public void addBehaviour(T abehaviour) { list.add(abehaviour); }

    public Aworker(){

        list = new ArrayList<T>();
    }




}
