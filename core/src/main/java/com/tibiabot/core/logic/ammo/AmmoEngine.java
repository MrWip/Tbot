package com.tibiabot.core.logic.ammo;

import com.tibiabot.core.logic.common.abstractions.Abehaviour;
import com.tibiabot.core.logic.common.abstractions.Aworker;

public class AmmoEngine extends Aworker<AmmoBehaviour> {


    @Override
    public void work() {

        for(AmmoBehaviour c : this.getList() ){

            if(getRobot().getPixelColor(c.getStartX(),c.getStartY()).getRGB() == c.getColor()){

                synchronized (this.getTibiaInputer()) {
                    this.getTibiaInputer().cast(c);
                }
                break;

            }

        }

    }
}
