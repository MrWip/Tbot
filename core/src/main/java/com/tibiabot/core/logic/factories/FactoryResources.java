package com.tibiabot.core.logic.factories;


import com.tibiabot.core.logic.common.resources.BotConfig;

public class FactoryResources {

    protected static int manaHpPercentValue(int value){

        float pixels = BotConfig.hpBarEndX - BotConfig.hpBarStartX;
        pixels = pixels/100;

        return  Math.round(pixels*value);

    }
}
