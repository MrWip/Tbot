package com.tibiabot.core.logic.healer.workers;

import com.tibiabot.core.logic.common.abstractions.Aworker;
import com.tibiabot.core.logic.healer.objects.HealBehaviour;
import com.tibiabot.core.logic.paralize.UtilSpellEngine;


public class HealerEngine extends Aworker<HealBehaviour> {

    private HpMChecker checker;
    private UtilSpellEngine utilEngine;

    public HealerEngine(UtilSpellEngine utilEngine){
        super();
        checker = new HpMChecker();
        this.utilEngine = utilEngine;
    }

    public void work()  {

            checker.setRobot(this.getRobot());
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
        utilEngine.work();
    }

}
