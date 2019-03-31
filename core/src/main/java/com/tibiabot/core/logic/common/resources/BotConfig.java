package com.tibiabot.core.logic.common.resources;

import java.awt.event.KeyEvent;

public class BotConfig {

    //The color code for the background point in the bars
    public static final int barBackground = -2404529;
    public static final int manaBackground =-10132752;
    public static final int hpBackground = -2404529;

    //Hp Bar
    public static final int hpBarStartX = 1767 ;
    public static final int hpBarEndX = 1857;
    public static final int hpBarY = 308;

    //Mana Bar
    public static final int manaBarStartX = 1767;
    public static final int manaBarEndX = 1857;
    public static final int manaBarY = 322;

    //no ammunition arrow color and coordinates
    public static final int ammoColor = -10657693;
    public static final int ammoX = 1834;
    public static final int ammoY= 237;

    //paralize variables add 10 for each check
    public static final int paralizeStartX = 1758;
    public static final int paralizeSartY = 292;
    public static final int paralizeColor = -65536;


    //Character values
    public static final int maxHp = 150;
    public static final int maxMana = 55;

    public static final String windowName = "Tibia - Lider Craves";

    //spell hotkeys

    public static final int heal1 = KeyEvent.VK_F6;
    public static final int heal2 = KeyEvent.VK_F7;
    public static final int heal3 = KeyEvent.VK_F8;
    public static final int heal4 = KeyEvent.VK_F9;
    public static final int mana1 = KeyEvent.VK_F10;

}
