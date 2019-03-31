package com.tibiabot.core.logic.common;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;
import com.tibiabot.core.logic.common.abstractions.Abehaviour;
import com.tibiabot.core.logic.common.resources.BotConfig;

import java.awt.*;

public class TibiaInputer {

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    private Robot robot;

    private final User32 user32;

    public TibiaInputer(){

        user32 = User32.INSTANCE;

    }

    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

        boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);

        WinDef.HWND SetFocus(WinDef.HWND hWnd);

        int GetWindowTextA(WinDef.HWND hWnd, byte[] lpString, int nMaxCount);

        WinDef.HWND GetForegroundWindow();

        WinDef.DWORD SendInput(WinDef.DWORD nInputs,
                               WinUser.INPUT[] pInputs,
                               int cbSize);

        void PostMessage(WinDef.HWND hWnd,
                         int msg,
                         WinDef.WPARAM wParam,
                         WinDef.LPARAM lParam);

        boolean SetForegroundWindow(WinDef.HWND hWnd);
    }

    public void cast(Abehaviour o) {

        synchronized (this) {

            WinDef.HWND hWnd = user32.GetForegroundWindow();
            byte[] windowText = new byte[512];
            user32.GetWindowTextA(hWnd, windowText, 512);
            String wText = Native.toString(windowText);
            if (wText.equals(BotConfig.windowName)) {

                robot.keyPress(o.getHotkey());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
