package com.devcon3.botbuddy.client.handler;

import com.devcon3.botbuddy.client.settings.Keybindings;
import com.devcon3.botbuddy.reference.Key;
import com.devcon3.botbuddy.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {

    private static Key getPressedKeybinding(){

        if(Keybindings.charge.isPressed()){

            return Key.CHARGE;
        }
        else if(Keybindings.release.isPressed()){

            return Key.RELEASE;
        }

        return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){

        LogHelper.info(getPressedKeybinding());
    }
}
