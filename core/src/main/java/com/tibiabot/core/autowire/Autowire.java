package com.tibiabot.core.autowire;



import com.tibiabot.core.logic.ammo.AmmoBehaviour;
import com.tibiabot.core.logic.ammo.AmmoEngine;
import com.tibiabot.core.logic.common.TibiaInputer;
import com.tibiabot.core.logic.eater.EaterEngine;
import com.tibiabot.core.logic.factories.Factory;
import com.tibiabot.core.logic.healer.workers.HealerEngine;
import com.tibiabot.core.logic.paralize.UtilSpellEngine;

import java.awt.*;

public  class Autowire {

    private HealerEngine healerEngine;
    private EaterEngine eaterEngine;
    private HealerEngine manaEngine;
    private AmmoEngine ammoEngine;
    private UtilSpellEngine utilEngine;

    public Factory wireBot() throws AWTException {

        Robot robot = new Robot();
        TibiaInputer inputer = new TibiaInputer();
        inputer.setRobot(robot);

        System.out.println(robot.getPixelColor(1733, 611).getRGB());

        //Engines
         utilEngine = new UtilSpellEngine();
         healerEngine = new HealerEngine(utilEngine);
         eaterEngine = new EaterEngine();
         manaEngine = new HealerEngine(utilEngine);
         ammoEngine = new AmmoEngine();


        //Engine setters
        healerEngine.setRobot(robot);
        healerEngine.setTibiaInputer(inputer);
        eaterEngine.setRobot(robot);
        eaterEngine.setTibiaInputer(inputer);
        manaEngine.setRobot(robot);
        manaEngine.setTibiaInputer(inputer);
        ammoEngine.setRobot(robot);
        ammoEngine.setTibiaInputer(inputer);
        utilEngine.setRobot(robot);
        utilEngine.setTibiaInputer(inputer);

        return new Factory();

    }

    public HealerEngine getHealerEngine() { return healerEngine; }

    public EaterEngine getEaterEngine() { return eaterEngine; }

    public HealerEngine getManaEngine() { return manaEngine; }

    public AmmoEngine getAmmoEngine() { return ammoEngine; }

    public UtilSpellEngine getUtilEngine() { return utilEngine; }
}
