package com.tibiabot.core.logic.healer.workers;

import com.tibiabot.core.logic.common.abstractions.Achecker;
import com.tibiabot.core.logic.healer.objects.HealBehaviour;

public class HpMChecker extends Achecker<HealBehaviour> {


    @Override
    public boolean check( HealBehaviour h) {

        if(h.getEndX() != -1 ){

            return this.getRobot().getPixelColor(h.getEndX(), h.getEndY()).getRGB() == h.getColor() ?
                    (this.getRobot().getPixelColor(h.getStartX(), h.getStartY()).getRGB() == h.getColor()): true;

        }

        return super.check(h);

    }
}
