package com.tibiabot.core.logic.factories;

import com.tibiabot.core.logic.ammo.AmmoBehaviour;
import com.tibiabot.core.logic.ammo.AmmoEngine;
import com.tibiabot.core.logic.common.SimpleBehaviour;
import com.tibiabot.core.logic.common.resources.BotConfig;
import com.tibiabot.core.logic.eater.EaterEngine;
import com.tibiabot.core.logic.eater.objects.EaterBehaviour;
import com.tibiabot.core.logic.healer.objects.HealBehaviour;
import com.tibiabot.core.logic.healer.workers.HealerEngine;
import com.tibiabot.core.logic.paralize.ParalyzeEngine;

public class Factory {

    private static FactoryUtils factoryUtils;

    public Factory(){
        factoryUtils = new FactoryUtils();
    }

    public static HealBehaviour createHpBehaviour(HealerEngine engine, int start, int end, int hotkey){

        HealBehaviour simple = new HealBehaviour();

        simple.setColor(BotConfig.hpBackground);
        simple.setHotkey(hotkey);
        simple.setStartX(BotConfig.hpBarStartX + factoryUtils.manaHpPercentValue(start));
        simple.setStartY(BotConfig.hpBarY);
        if(end < 0){

            simple.setEndX(-1);
            simple.setEndY(-1);

        }
        else {
            simple.setEndX(BotConfig.hpBarStartX + factoryUtils.manaHpPercentValue(end));
            simple.setEndY(BotConfig.hpBarY);
        }
        engine.getList().add(simple);
        return simple;

    }

    public static HealBehaviour createManaBehaviour(HealerEngine engine, int start, int end, int hotkey){

        HealBehaviour simple = new HealBehaviour();

        simple.setColor(BotConfig.manaBackground);
        simple.setHotkey(hotkey);
        simple.setStartX(BotConfig.manaBarStartX + factoryUtils.manaHpPercentValue(start));
        simple.setStartY(BotConfig.manaBarY);
        if(end < 0){

            simple.setEndX(-1);
            simple.setEndY(-1);

        }
        else{

            simple.setEndX(BotConfig.manaBarStartX + factoryUtils.manaHpPercentValue(end));
            simple.setEndY(BotConfig.manaBarY);
        }

        engine.getList().add(simple);
        return simple;

    }

    public static EaterBehaviour createEaterBehaviour(EaterEngine engine, int timer, int hotkey){

        EaterBehaviour b = new EaterBehaviour();

        b.setTimer(timer);
        b.setStartY(-1);
        b.setStartX(-1);
        b.setHotkey(hotkey);
        b.setColor(-1);
        engine.addBehaviour(b);

        return b;
    }

    public static AmmoBehaviour createAmmoBehaviour(AmmoEngine engine, int hotkey){

        AmmoBehaviour ammoBehaviour = new AmmoBehaviour();

        ammoBehaviour.setColor(BotConfig.ammoColor);
        ammoBehaviour.setHotkey(hotkey);
        ammoBehaviour.setStartX(BotConfig.ammoX);
        ammoBehaviour.setStartY(BotConfig.ammoY);
        engine.addBehaviour(ammoBehaviour);

        return ammoBehaviour;

    }

    public static SimpleBehaviour createParalizeBehaviour(ParalyzeEngine engine, int hotkey){

        SimpleBehaviour utilSpellBehaviour = new SimpleBehaviour();

        utilSpellBehaviour.setColor(BotConfig.paralizeColor);
        utilSpellBehaviour.setStartX(BotConfig.paralizeStartX);
        utilSpellBehaviour.setStartY(BotConfig.paralizeSartY);
        utilSpellBehaviour.setHotkey(hotkey);

        engine.addBehaviour(utilSpellBehaviour);
        return utilSpellBehaviour;
    }

}
