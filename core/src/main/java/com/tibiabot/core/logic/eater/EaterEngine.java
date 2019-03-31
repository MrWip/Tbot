package com.tibiabot.core.logic.eater;

import com.tibiabot.core.logic.common.abstractions.Aworker;
import com.tibiabot.core.logic.eater.objects.EaterBehaviour;


public class EaterEngine extends Aworker<EaterBehaviour> {

    public void work() {

            for (EaterBehaviour o : this.getList()) {
                synchronized (this.getTibiaInputer()) {
                this.getTibiaInputer().cast(o);
                break;
            }

        }
    }
}
