package com.tibiabot.core.logic.healer.workers;

import com.tibiabot.core.logic.common.abstractions.Aworker;
import com.tibiabot.core.logic.healer.objects.HealBehaviour;
import com.tibiabot.core.logic.paralize.ParalyzeEngine;
import org.springframework.beans.factory.annotation.Autowired;


public class HealerEngine extends Aworker<HealBehaviour> {

    @Autowired
    private HpMChecker checker;

    @Autowired
    private ParalyzeEngine paralyzeEngine;

    public HealerEngine(){
        super();
    }

    public void work()  {

            for (HealBehaviour s : this.getList()) {
                if (!checker.check(s)) {
                    synchronized (this.getTibiaInputer()) {
                        this.getTibiaInputer().cast(s);
                    }
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return;
                }
        }
        paralyzeEngine.work();
    }


}
